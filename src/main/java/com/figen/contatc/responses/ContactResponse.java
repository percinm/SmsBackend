package com.figen.contatc.responses;

import com.figen.contatc.entities.Contact;
import lombok.Data;

@Data
public class ContactResponse {

    Long id;
    String name;
    String phoneNumber;

    public ContactResponse(Contact entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.phoneNumber = entity.getPhoneNumber();
    }
}
