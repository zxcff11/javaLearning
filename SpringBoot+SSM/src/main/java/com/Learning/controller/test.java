package com.Learning.controller;


import com.Learning.entity.po.Car;
import com.Learning.entity.po.UserInfo;
import com.Learning.entity.vo.R;
import com.Learning.service.UserInfoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class test {
    @Resource
    private UserInfoService userInfoService;
    //第一个MyBatis
    @RequestMapping("/test1")
    public UserInfo test1() {
        return userInfoService.getSecondRegisterUser();
    }
    //$符测试
    @RequestMapping("/test2")
    public List<UserInfo> test2() {
        return userInfoService.getUserList();
    }

    @RequestMapping("/detail")
    public List<R<Object>> test3() {
        List<R<Object>> list  =new ArrayList<>();
        list.add(R.OK());
        list.add(R.FAIL());
        return list;
    }
}
