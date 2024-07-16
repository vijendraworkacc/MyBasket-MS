package com.company.mybasket.fraudcheck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

//@EnableFeignClients(
//        basePackages = "com.company.mybasket.client.fraudcheck"
//)
@EnableEurekaClient
@SpringBootApplication
public class FraudCheckApplication {
    public static void main(String[] args) {
        SpringApplication.run(FraudCheckApplication.class, args);
    }
}
