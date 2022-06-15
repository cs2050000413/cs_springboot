package com.kaishun.study.service.impl;

import com.kaishun.study.entity.TbUser;
import com.kaishun.study.service.RedisService;
import com.kaishun.study.service.TbUserService;
import com.kaishun.study.service.TokenUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName:    TokenUserServiceImpl
 * Package:    com.kaishun.study.service.impl
 * Description:
 * Datetime:    2020/2/26   10:56
 * Author:   zhoukaishun
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@Service
public class TokenUserServiceImpl implements TokenUserService {

    @Autowired
    private RedisService redisService;

    @Autowired
    private TbUserService tbUserService;

    @Override
    public String findUserId(String token) {
        return redisService.get(token);
    }

    @Override
    public TbUser findTbUser(String token) {
        String userId = this.findUserId(token);
        return tbUserService.queryById(userId);
    }
}
