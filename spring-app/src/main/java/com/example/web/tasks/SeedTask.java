package com.example.web.tasks;

import com.example.commons.domain.ChatMessage;
import com.example.web.publishers.ChatMessagePublisher;
import com.example.commons.repositories.ChatMessageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

import static java.lang.Thread.sleep;


@Slf4j
@Component
public class SeedTask implements CommandLineRunner {

    @Autowired
    ChatMessagePublisher publisher;

    @Autowired
    ChatMessageRepository repository;


    @Override
    public void run(String... args) throws Exception {


        log.info("SeedTask");


        // this can be a pooler in a endpoint
        while(true) {
            try {
                sleep(500);
                ChatMessage chatMsg = ChatMessage.builder()
                        .sessionId("teste-xyz")
                        .createdAt(new Date())
                        .text("mensagem de teste")
                        .build();

                publisher.publish(chatMsg);
                log.info("publish one message");

                repository.save(chatMsg);
            } catch (Exception ex) {
                log.error(ex.getMessage());
            }
        }

    }
}
