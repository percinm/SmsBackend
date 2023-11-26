package com.figen.contatc.controllers;

import com.figen.contatc.entities.Contact;
import com.figen.contatc.requests.ContactCreateRequest;

import com.figen.contatc.responses.MessageResponse;
import com.figen.contatc.services.ContactService;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/directory")
public class ContactController {

	private ContactService contactService;

	public ContactController(ContactService contactService) {

		this.contactService = contactService;
	}

	@GetMapping
	public List<Contact> getAllContact() {

		return contactService.getAllContact();
	}


	@PostMapping
	public ResponseEntity<Void> createReceiver(@RequestBody @NotNull ContactCreateRequest request) {

		contactService.saveOneContact(request);

		return new ResponseEntity<>(HttpStatus.CREATED);

	}

	@GetMapping("/{contactId}")
	public List<MessageResponse> getMessagesByContactId(@PathVariable Long contactId) {

		return contactService.getMessagesByContactId(contactId);
	}

}
