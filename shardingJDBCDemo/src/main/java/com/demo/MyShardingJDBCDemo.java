package com.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = {"com.demo"})
@MapperScan(basePackages = {"com.demo.mappers"})
@EnableTransactionManagement
public class MyShardingJDBCDemo {
    public static void main(String[] args) {
        SpringApplication.run(MyShardingJDBCDemo.class, args);
    }
}
