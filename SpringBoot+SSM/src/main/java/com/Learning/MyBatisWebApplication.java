package com.Learning;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = {"com.Learning"})
@MapperScan(basePackages = {"com.Learning.mappers"})
@EnableTransactionManagement
public class MyBatisWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyBatisWebApplication.class, args);
    }
}