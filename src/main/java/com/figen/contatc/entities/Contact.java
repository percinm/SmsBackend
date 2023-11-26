package com.figen.contatc.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="contact")
@Data
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String recordTime;
    String name;
    String phoneNumber;

}
