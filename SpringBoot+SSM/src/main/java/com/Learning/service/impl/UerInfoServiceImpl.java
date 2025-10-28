package com.Learning.service.impl;

import com.Learning.entity.po.UserInfo;
import com.Learning.mappers.UserInfoMapper;
import com.Learning.query.UserInfoQuery;
import com.Learning.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class UerInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> getUserList() {
        log.info("123");
        UserInfoQuery userInfoQuery = new UserInfoQuery();
        userInfoQuery.setOrderBy("id desc");
        return userInfoMapper.selectList(userInfoQuery);
    }


    @Override
    public UserInfo getSecondRegisterUser() {
        return userInfoMapper.getSecondRegisterUser();
    }
}
