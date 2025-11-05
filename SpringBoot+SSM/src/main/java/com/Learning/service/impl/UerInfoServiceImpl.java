package com.Learning.service.impl;

import com.Learning.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RBloomFilter;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import static com.Learning.entity.constant.RedisKeyConstant.USER_REGISTER;

@Service
@Slf4j
@RequiredArgsConstructor
public class UerInfoServiceImpl implements UserInfoService {

    private final RBloomFilter<String> userRegisterCachePenetrationBloomFilter;
    private final StringRedisTemplate stringRedisTemplate;

    private Boolean hasUsername(String username) {

        /*
         *   布隆过滤器中存在
         *       set中存在 返回false
         *       set中不存在 true
         *   布隆过滤器中不存在 ;
         *
         *  */
        if (userRegisterCachePenetrationBloomFilter.contains(username)) {
            return Boolean.FALSE.equals(stringRedisTemplate.opsForSet().isMember(USER_REGISTER, username));
        }
        return false;
    }


    public String register(String email, String username, String password) {
        if (!hasUsername(username)) {
            // stringRedisTemplate.opsForSet().add(USER_REGISTER, username);
            userRegisterCachePenetrationBloomFilter.add(username);
            stringRedisTemplate.opsForSet().remove(USER_REGISTER, username);
            return "用户注册成功: " + username;
        } else {
            return "用户注册失败，用户名已存在: " + username;
        }
    }

    @Override
    public void delete(String username) {
        stringRedisTemplate.opsForSet().add(USER_REGISTER, username);
    }

// @Override
// public void updateUserInfo(UserInfo userInfo, MultipartFile avatar) {
//
// }
}
