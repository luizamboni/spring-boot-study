package com.example.Abc.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnyController {

    @Value("${messages.hello}")
    private String content;

    @GetMapping("/any")
    public String thing() {

        return content;
    }
}
