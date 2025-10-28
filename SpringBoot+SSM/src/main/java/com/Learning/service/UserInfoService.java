package com.Learning.service;

import com.Learning.entity.po.UserInfo;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserInfoService {
    //获取第二晚注册的用户
    UserInfo getSecondRegisterUser();
    List<UserInfo> getUserList();

}
