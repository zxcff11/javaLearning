package com.Learning.mappers;

import com.Learning.entity.po.UserInfo;
import com.Learning.query.UserInfoQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserInfoMapper {

    UserInfo getSecondRegisterUser();
    List<UserInfo> selectList(@Param("query") UserInfoQuery query);

}
