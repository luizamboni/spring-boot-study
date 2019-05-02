package com.example.Abc.rest;

import com.example.Abc.externals.AbcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnyController {

    @Autowired
    AbcClient abcClient;

    @Value("${messages.hello}")
    private String content;

    @GetMapping("/${spring.application.name}/any")
    public String any() {
        return content;
    }

    @GetMapping("/${spring.application.name}/thing")
    public String thing() {
        String messageFromOther = abcClient.any();

        return content + " -- " + messageFromOther;
    }
}
