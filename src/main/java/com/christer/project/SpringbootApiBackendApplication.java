package com.christer.project;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication
@EnableDubbo
public class SpringbootApiBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApiBackendApplication.class, args);
    }

}
