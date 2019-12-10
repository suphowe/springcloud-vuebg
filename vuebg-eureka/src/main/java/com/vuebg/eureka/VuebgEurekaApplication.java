package com.vuebg.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class VuebgEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(VuebgEurekaApplication.class, args);
    }

}
