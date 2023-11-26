package com.figen.contatc.repos;

import com.figen.contatc.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ContactRepository extends JpaRepository<Contact, Long> {
    Contact findIdByPhoneNumber(String phoneNumber);
}
