package com.example.web.tasks;

import com.example.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRunnerExample implements ApplicationRunner {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public void run(ApplicationArguments args) {
        log.info("ApplicationRunnerExample");
        log.info(args.toString());
    }
}
