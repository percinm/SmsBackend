package com.figen.contatc.controllers;

import com.figen.contatc.entities.Message;
import com.figen.contatc.requests.MessageRequest;
import com.figen.contatc.responses.ContactResponse;
import com.figen.contatc.services.MessageService;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public List<Message> getAllMessage() {

        return messageService.getAllMessage();
    }


    @PostMapping
    public ResponseEntity<Void> createOneMessage(@RequestBody @NotNull MessageRequest request) {

        messageService.saveOneMessage(request);

        return new ResponseEntity<>( HttpStatus.CREATED);
    }

    @GetMapping("/{messageId}")
    public List<ContactResponse> getReceiverNames(@PathVariable Long messageId) {
        return messageService.getContactNamesByMessageId(messageId);
    }

}
