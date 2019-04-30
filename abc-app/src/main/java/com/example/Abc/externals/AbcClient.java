package com.example.Abc.externals;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;


@FeignClient("a")
public interface AbcClient {


    @RequestMapping("/any")
    String any();
}