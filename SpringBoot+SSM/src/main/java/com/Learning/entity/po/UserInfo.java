package com.Learning.entity.po;

import com.Learning.entity.enums.DateTimePatternEnum;
import com.Learning.entity.vo.UserInfoVO;
import com.Learning.serialize.NameDesensitizationSerializer;
import com.Learning.utils.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * 用户信息
 */
@Data
@Builder
public class UserInfo implements Serializable {


    /**
     * 用户ID
     */
    private String userId;

    /**
     * 昵称
     */
    @JsonSerialize(using = NameDesensitizationSerializer.class)
    private String name;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 密码
     */
    @JsonIgnore
    private String password;

    /**
     * 0:女 1:男
     */
    private Integer sex;

    /**
     * 加入时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date joinTime;

    /**
     * 最后登录时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastLoginTime;


}
