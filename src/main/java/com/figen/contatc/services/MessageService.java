package com.figen.contatc.services;

import com.figen.contatc.entities.Contact;
import com.figen.contatc.entities.Message;
import com.figen.contatc.entities.Receiver;
import com.figen.contatc.repos.MessageRepository;
import com.figen.contatc.repos.ReceiverRepository;
import com.figen.contatc.requests.MessageRequest;
import com.figen.contatc.responses.ContactResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;
    @Autowired
    ReceiverRepository receiverRepository;
    @Autowired
    ContactService contactService;

    public MessageService(MessageRepository messageRepository, ReceiverRepository receiverRepository, ContactService contactService) {

        this.messageRepository = messageRepository;
        this.receiverRepository = receiverRepository;
        this.contactService = contactService;
    }

    public List<Message> getAllMessage() {

        return messageRepository.findAll();
    }

    public Message saveOneMessage(MessageRequest request) {

        Message messageToSave = new Message();
        messageToSave.setText(request.getText());
        messageToSave.setDescription(request.getDescription());
        messageToSave.setStatusCode(request.getStatusCode());
        messageToSave.setSendDate(request.getSendDate());

        Message savedMessage = messageRepository.save(messageToSave);

        List<String> receiverPhoneNumbers = request.getReceiver();

        for (String receiverPhoneNumber : receiverPhoneNumbers) {
            Contact contact = contactService.getContactIdByPhoneNumber(receiverPhoneNumber);
                Receiver receiver = new Receiver();
                receiver.setContact(contact);
                receiver.setMessage(savedMessage);
                receiverRepository.save(receiver);
        }

        return savedMessage;
    }

    public List<ContactResponse> getContactNamesByMessageId(Long messageId) {

        List<Receiver> contacts = receiverRepository.findAllByMessageId(messageId);;

        return contacts.stream().map(contact -> new ContactResponse(contact.getContact())).collect(Collectors.toList());
    }
}
