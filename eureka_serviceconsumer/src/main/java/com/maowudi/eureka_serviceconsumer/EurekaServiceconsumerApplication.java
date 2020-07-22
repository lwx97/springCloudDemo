package com.maowudi.eureka_serviceconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix //开启熔断器服务
public class EurekaServiceconsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServiceconsumerApplication.class, args);
    }

    /**
     * springcloud中提倡rest风格的微服务
     * 想spring容器中注入RestTemplate
     *
     * 使用LoadBalanced表明这个restRemplate开启负载均衡的功能。
     * @return
     */
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
