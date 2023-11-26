package com.figen.contatc.requests;

import lombok.Data;

import java.util.List;

@Data
public class MessageRequest {

    String text;
    String description;
    short statusCode;
    String sendDate;
    List<String> receiver;
}
