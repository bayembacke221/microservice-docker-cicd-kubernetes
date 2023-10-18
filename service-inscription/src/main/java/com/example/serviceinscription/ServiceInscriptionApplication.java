package com.example.serviceinscription;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServiceInscriptionApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceInscriptionApplication.class, args);
    }

}
