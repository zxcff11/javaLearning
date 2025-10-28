package com.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.demo.entity.UserDO;
import com.demo.mappers.UserMapper;
import com.demo.service.UserService;
import org.springframework.stereotype.Component;

/**
 * 用户信息接口实现层
 *
 * @公众号：马丁玩编程，回复：加群，添加马哥微信（备注：ladder）获取更多项目资料
 */
@Component
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {
}
