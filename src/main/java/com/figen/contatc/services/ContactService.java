package com.figen.contatc.services;

import com.figen.contatc.entities.Contact;
import com.figen.contatc.entities.Receiver;
import com.figen.contatc.repos.ContactRepository;
import com.figen.contatc.repos.ReceiverRepository;
import com.figen.contatc.requests.ContactCreateRequest;
import com.figen.contatc.responses.MessageResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactService {

    @Autowired
    ContactRepository contactRepository;
    @Autowired
    ReceiverRepository receiverRepository;

    public ContactService(ContactRepository contactRepository, ReceiverRepository receiverRepository) {

        this.contactRepository = contactRepository;
        this.receiverRepository = receiverRepository;
    }

    public List<Contact> getAllContact() {

        return contactRepository.findAll();
    }

    public Contact saveOneContact(@NotNull ContactCreateRequest request) {

        Contact contactToSave = new Contact();
        contactToSave.setName(request.getName());
        contactToSave.setPhoneNumber(request.getPhoneNumber());
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm dd-MM-yyyy");
        String formattedDateTime = dateFormat.format(new Date());
        contactToSave.setRecordTime(formattedDateTime);

        return contactRepository.save(contactToSave);
    }

    public Contact getContactIdByPhoneNumber(String phoneNumber) {
        return contactRepository.findIdByPhoneNumber(phoneNumber);
    }


    public List<MessageResponse> getMessagesByContactId(Long contactId) {

        List<Receiver> messages = receiverRepository.findAllByContactId(contactId);

        return messages.stream().map(message -> new MessageResponse(message.getMessage())).collect(Collectors.toList());
    }
}
