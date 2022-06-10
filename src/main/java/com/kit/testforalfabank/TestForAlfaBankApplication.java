package com.kit.testforalfabank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TestForAlfaBankApplication {

    public static void main(String[] args){
        SpringApplication.run(TestForAlfaBankApplication.class, args);
    }
}
