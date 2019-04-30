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

    @GetMapping("/any")
    public String any() {

        return content;
    }

    @GetMapping("/thing")
    public String thing(){
        return abcClient.any();
    }
}
