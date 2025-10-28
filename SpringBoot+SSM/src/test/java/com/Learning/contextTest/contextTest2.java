package com.Learning.contextTest;

import com.Learning.query.BaseParam;
import com.Learning.service.UserInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.Map;

@SpringBootTest
public class contextTest2 {
    @Autowired
    private ApplicationContext applicationContext;
    @Test
    void test2() {
        Map<String, UserInfoService> beansOfType = applicationContext.getBeansOfType(UserInfoService.class);
        System.out.println("***********************************");
        System.out.println(beansOfType);
    }
}
