package com.example.Abc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication
@EnableEurekaClient
@Configuration
@EnableFeignClients
public class AbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbcApplication.class, args);
	}

}
