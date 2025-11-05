package com.Learning.entity.config;


import lombok.Data;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class UserRegisterBloomFilterProperties {

    private String name = "regiserBloomfilter";
    private Long expectedInsertions = 64L;
    private Double falseProbability = 0.03D;

}
