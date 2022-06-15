package com.kaishun.study.service;

import com.kaishun.study.entity.TbUser;

/**
 * ClassName:    TokenService
 * Package:    com.kaishun.study.service
 * Description:
 * Datetime:    2020/2/26   10:55
 * Author:   zhoukaishun
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
public interface TokenUserService {

    String findUserId(String token);

    TbUser findTbUser(String token);

}
