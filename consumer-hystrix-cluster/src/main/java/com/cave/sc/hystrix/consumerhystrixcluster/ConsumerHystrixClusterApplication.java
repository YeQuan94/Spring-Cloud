package com.cave.sc.hystrix.consumerhystrixcluster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
@SpringBootApplication
public class ConsumerHystrixClusterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerHystrixClusterApplication.class, args);
    }
}
