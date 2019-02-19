package com.example.web.tasks;

import com.example.Application;
import com.example.web.repositories.ThingsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static java.lang.Thread.sleep;


@Component
public class SeedTask implements CommandLineRunner {

    ThingsRepository repository;
    private static final Logger log = LoggerFactory.getLogger(Application.class);

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
//        while(true) {
//            sleep(1000);
//
//            log.info("more one second");
//        }

    }
}
