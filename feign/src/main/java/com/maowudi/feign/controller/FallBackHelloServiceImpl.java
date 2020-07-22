package com.maowudi.feign.controller;

import org.springframework.stereotype.Component;

@Component
public class FallBackHelloServiceImpl implements HelloService{


    @Override
    public String hi(String name) {
        return "fallBack HelloService hi : " + name;
    }
}
