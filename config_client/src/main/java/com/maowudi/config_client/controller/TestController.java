package com.maowudi.config_client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Value("${name}")
    private String name;

    @RequestMapping("/")
    public String test(){
        return "hello " + this.name;
    }
}
