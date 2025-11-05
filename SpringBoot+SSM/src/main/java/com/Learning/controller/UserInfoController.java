package com.Learning.controller;

import com.Learning.entity.po.UserInfo;
import com.Learning.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class UserInfoController {
    private final UserInfoService userInfoService;

    @RequestMapping("/userInfo")
    public UserInfo userInfo() {
        UserInfo userInfo = UserInfo.builder()
                .name("钟乐乐")
                .password("123456")
                .sex(1)
                .build();
        return userInfo;
    }

    @PostMapping("/register")
    public String register(String email, String username, String password) {

        return userInfoService.register(email, username, password);
    }

    @DeleteMapping("/delete")
    public String delete(String username) {
        userInfoService.delete(username);
        return "删除用户：" + username;
    }
}
