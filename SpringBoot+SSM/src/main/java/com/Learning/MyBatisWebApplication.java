package com.Learning;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.Learning"})
@MapperScan(basePackages = {"com.Learning.mappers"})
public class MyBatisWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyBatisWebApplication.class, args);
    }
}