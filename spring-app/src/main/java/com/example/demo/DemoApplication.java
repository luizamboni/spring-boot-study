package com.example.demo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(ThingsRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new Any("Jack"));
			repository.save(new Any("Chloe"));
			repository.save(new Any("Kim"));
			repository.save(new Any("David"));
			repository.save(new Any("Michelle"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Any thing : repository.findAll()) {
				log.info(thing.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			repository.findById(1L)
				.ifPresent(thing -> {
					log.info("Customer found with findById(1L):");
					log.info("--------------------------------");
					log.info(thing.toString());
					log.info("");
				});

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByName("Kim").forEach(kim -> {
				log.info(kim.toString());
			});

			log.info("");
		};
	}

}
