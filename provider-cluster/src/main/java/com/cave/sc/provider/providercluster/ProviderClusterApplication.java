package com.cave.sc.provider.providercluster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ProviderClusterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderClusterApplication.class, args);
    }
}
