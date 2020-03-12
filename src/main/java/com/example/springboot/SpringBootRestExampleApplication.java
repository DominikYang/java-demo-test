package com.example.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan(basePackages = "com.example.springboot.dao")
public class SpringBootRestExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestExampleApplication.class, args);
    }
}
