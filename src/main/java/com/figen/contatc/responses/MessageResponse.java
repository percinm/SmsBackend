package com.figen.contatc.responses;

import com.figen.contatc.entities.Contact;
import com.figen.contatc.entities.Message;
import lombok.Data;

@Data
public class MessageResponse {

    Long id;
    String text;
    short statusCode;
    String sendDate;

    public MessageResponse(Message entity) {
        this.id = entity.getId();
        this.text = entity.getText();
        this.statusCode = entity.getStatusCode();
        this.sendDate = entity.getSendDate();
    }
}
