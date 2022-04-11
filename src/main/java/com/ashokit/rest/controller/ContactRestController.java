package com.ashokit.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.entity.Contact;
import com.ashokit.service.ContactService;

@RestController
public class ContactRestController {
	
	@Autowired
	ContactService contactService;

	@PostMapping("/contact")
	public String saveContact(@RequestBody Contact contact) {
		boolean status = contactService.saveContact(contact);
		if (status) {
			return "Contact Saved";
		} else {
			return "Failed to save contact";
		}
	}
	@GetMapping("/contacts")
	public List<Contact> getAllContact() {
		return contactService.getAllContacts();
	}

	@GetMapping("contact/{cid}")
	public Contact editContact(@PathVariable("cid") Integer contactid) {
		return contactService.getContactById(contactid);
	}

	@DeleteMapping("/contact/{cid}")
	public String deleteContact(@PathVariable("cid") Integer contactId) {
		boolean status = contactService.deleteContactById(contactId);
		if (status) {
			return "Contact Deleted";
		} else {
			return "Failed to delete contact";
		}
	}

}
