package com.figen.contatc.responses;

import lombok.Data;

@Data
public class ContactCreateResponse {

    String name;
    String phoneNumber;
    String message;
}
