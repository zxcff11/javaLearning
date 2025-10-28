package com.aopTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.aopTest"})
public class AopTestRunner {
    public static void main(String[] args) {
        SpringApplication.run(AopTestRunner.class, args);
    }
}
