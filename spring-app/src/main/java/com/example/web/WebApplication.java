package com.example.web;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
/**
 * make spring load commons package too
 */
@ComponentScan({
    "com.example.commons",
    "com.example.web"
})

@EnableJpaRepositories({"com.example.commons.repositories"})
@EntityScan(basePackages = "com.example.commons.domain")
public class WebApplication {
}
