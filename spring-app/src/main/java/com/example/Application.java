package com.example;

import com.example.web.WebApplication;
import com.example.poller.PollerApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) throws Exception {


//		String mode = (args.length == 0) ? "poller" : args[0];
		String mode = (args.length == 0) ? "web" : args[0];


		ApplicationContext context;

		if(mode.equals("web")) {
			log.info("web mode inited");
			context = SpringApplication.run(WebApplication.class, args);

		} else if (mode.equals("poller")) {

			log.info("poller mode inited");
			context = SpringApplication.run(PollerApplication.class, args);

		} else {
			throw new Exception("invalid mode argment: " + mode);
		}

		log.info(context.toString());
	}
}