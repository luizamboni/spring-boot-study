package com.example.Abc.externals;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;


@FeignClient(name = "${abcclient.name}")
public interface AbcClient {


    @RequestMapping("${abcclient.name}/any")
    String any();
}