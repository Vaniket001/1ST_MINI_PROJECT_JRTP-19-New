package com.ashokit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.entity.Contact;
import com.ashokit.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	ContactRepository contactRepository;

	@Override
	public boolean saveContact(Contact contact) {
		contact.setActiveSw("Y");
		Contact contactRepo= contactRepository.save(contact);
		if(contactRepo.getContactId() !=null) {
			return true;
		}
		return false;
	}

	@Override
	public List<Contact> getAllContacts() {
		return contactRepository.findAll();
	}

	@Override
	public Contact getContactById(Integer contactId) {
		Optional<Contact> findById=contactRepository.findById(contactId);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public boolean deleteContactById(Integer contactId) {
		Optional<Contact> findById=contactRepository.findById(contactId);
		if(findById.isPresent()) {
			Contact contact= findById.get();
			contact.setActiveSw("N");
			contactRepository.save(contact);
			return true;
		}
		return false;
	}

}
