package com.example.commons.repositories;

import java.util.List;

import com.example.commons.domain.ChatMessage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatMessageRepository extends CrudRepository<ChatMessage, Long> {

    ChatMessage findById(String id);

}