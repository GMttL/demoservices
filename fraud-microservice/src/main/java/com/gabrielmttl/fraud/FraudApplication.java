package com.gabrielmttl.fraud;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class FraudApplication {

        public static void main(String[] args) {
            org.springframework.boot.SpringApplication.run(FraudApplication.class, args);
        }
}
