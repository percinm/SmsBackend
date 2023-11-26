package com.figen.contatc.requests;

import lombok.Data;

@Data
public class ContactCreateRequest {

    String name;
    String phoneNumber;
    String recordTime;

}
