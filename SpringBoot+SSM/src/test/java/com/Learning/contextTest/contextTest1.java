package com.Learning.contextTest;

import com.Learning.query.BaseParam;
import com.Learning.service.UserInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.Learning.contextTest.ApplicationContextHolder;

import java.util.Map;

@SpringBootTest
public class contextTest1 {
    @Test
    void test2() {

        Map<String, UserInfoService> beansOfType = ApplicationContextHolder.getBeansOfType(UserInfoService.class);
        System.out.println("***********************************");
        System.out.println(beansOfType);
    }
}
