package com.example.web.tasks;

import com.example.Application;
import com.example.web.domain.ChatMessage;
import com.example.web.publishers.ChatMessagePublisher;
import com.example.web.repositories.ThingsRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

import static java.lang.Thread.sleep;


@Component
@Slf4j
public class SeedTask implements CommandLineRunner {

    @Autowired
    ChatMessagePublisher publisher;

    ThingsRepository repository;

//    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public SeedTask(ThingsRepository repository) {

        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {


        log.info("SeedTask");

//        // save a couple of customers
//        repository.save(new Any("Jack"));
//        repository.save(new Any("Chloe"));
//        repository.save(new Any("Kim"));
//        repository.save(new Any("David"));
//        repository.save(new Any("Michelle"));
//
//        // fetch all customers
//        log.info("Customers found with findAll():");
//        log.info("-------------------------------");
//        for (Any thing : repository.findAll()) {
//            log.info(thing.toString());
//        }
//        log.info("");
//
//        // fetch an individual customer by ID
//        repository.findById(1L)
//            .ifPresent(thing -> {
//                log.info("Customer found with findById(1L):");
//                log.info("--------------------------------");
//                log.info(thing.toString());
//                log.info("");
//            });
//
//        // fetch customers by last name
//        log.info("Customer found with findByLastName('Kim'):");
//        log.info("--------------------------------------------");
//
//        repository.findByName("Kim").forEach(kim -> {
//            log.info(kim.toString());
//        });

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
                log.info("more one loop");
            } catch (Exception ex) {
                log.error(ex.getMessage());
            }
        }

    }
}
