package com.Learning.controller;

import com.Learning.entity.po.UserInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserInfoController {
    @RequestMapping("/userInfo")
    public UserInfo userInfo() {
        UserInfo userInfo = UserInfo.builder()
                .name("钟乐乐")
                .password("123456")
                .sex(1)
                .build();
        return userInfo;
    }
}
