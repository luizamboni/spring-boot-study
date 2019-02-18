package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;


public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) throws Exception {

		String mode = (args.length == 0) ? "web" : args[0];
		ApplicationContext context;

		if(mode == "web") {
			log.info("web mode inited");
			context = SpringApplication.run(WebApplication.class, args);

		} else if (mode == "poller") {

			log.info("poller mode inited");
			context = SpringApplication.run(PollerApplication.class, args);

		} else {
			throw new Exception("invalid mode argment: " + mode);
		}

		log.info(
			"PollerMessage: " + context.containsBean("PollerMessage")
		);

	}
}