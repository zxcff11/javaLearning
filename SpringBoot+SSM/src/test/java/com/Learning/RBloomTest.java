package com.Learning;

import com.Learning.service.UserInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
public class RBloomTest {
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void reg1() {
        userInfoService.register("147258@qq.com", "zxcff11", "Martin");
    }

    @Test
    void reg2() {
        userInfoService.register("147258@qq.com", "zxcff11", "Martin");
    }
}
