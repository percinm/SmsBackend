package com.figen.contatc.repos;

import com.figen.contatc.entities.Receiver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReceiverRepository extends JpaRepository<Receiver, Long> {

    List<Receiver> findAllByMessageId(Long postId);

    List<Receiver> findAllByContactId(Long contactId);
}
