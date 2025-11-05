package com.Learning.service;

public interface UserInfoService {
    // 获取第二晚注册的用户
    // UserInfo getSecondRegisterUser();

    // List<UserInfo> getUserList();

    String register(String email, String nickName, String password);

    void delete(String username);

    // void updateUserInfo(UserInfo userInfo, MultipartFile avatar);


}
