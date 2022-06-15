package com.kaishun.study.Initialization;

import com.kaishun.study.entity.TbUser;
import com.kaishun.study.service.TbUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ClassName:    UserMap
 * Package:    com.kaishun.study.Initialization
 * Description: 暂时用于测试，后续可更改
 * Datetime:    2020/2/18   13:21
 * Author:   zhoukaishun
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@Component
public class TbUserMap implements InitializingBean {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private Map<String, TbUser> tbUserMap=new ConcurrentHashMap<>();

    @Autowired
    private TbUserService tbUserService;


    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("用户信息缓存");
        tbUserService.findAll().stream().forEach(tbUser->tbUserMap.put(tbUser.getId(),tbUser));
    }

    public TbUser get(String id){
        return tbUserMap.get(id);
    }

    public void remove(String id){
        tbUserMap.remove(id);
    }

    public void put(TbUser tbUser){
        tbUserMap.put(tbUser.getId(),tbUser);
    }


}
