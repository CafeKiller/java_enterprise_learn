package com.coffee.mall_tiny01.service.impl;

import com.coffee.mall_tiny01.common.api.CommonResult;
import com.coffee.mall_tiny01.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.RedisServer;

public class UmsMemberServiceImpl implements UmsMemberService {

    @Autowired
    private RedisServer redisServer;

    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;

    @Value("${redis.key.expire.authCode}")
    private Long AUTH_CODE_EXPIRE_SECONDS;

    @Override
    public CommonResult generateAuthCode(String telephone) {
        return null;
    }

    @Override
    public CommonResult verifyAuthCode(String telephone, String authCode) {
        return null;
    }
}
