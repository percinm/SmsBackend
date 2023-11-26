package com.figen.contatc.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="receiver")
@Data
public class Receiver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="contact_id", nullable=false)
    @JsonIgnore
    Contact contact;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="message_id", nullable=false)
    @JsonIgnore
    Message message;

}
