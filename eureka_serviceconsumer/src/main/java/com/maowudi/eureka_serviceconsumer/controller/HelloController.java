package com.maowudi.eureka_serviceconsumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hi")
    @HystrixCommand(fallbackMethod = "fallBack_hi")
    public String hi(String name) {
        return restTemplate.getForObject("http://eureka-provider?name=" + name,String.class);
    }

    /**
     * 如果hi服务调用失败，调用该方法
     * @param name
     * @return
     */
    private String fallBack_hi(String name) {
        return "fallBack hi " + name;
    }
}
