package com.kaishun.study.responsibility;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Package: com.kaishun.study.responsibility
 * @ClassName: CheckBlackFilterObject
 * @Author: zhoukaishun
 * @CreateTime: 2021/11/2 11:24
 * @Description: 黑名单校验
 */
@Component
@Order(3)
public class CheckBlackFilterObject extends AbstractHandler{
    @Override
    protected void doFilter(Object object) {
        System.out.println("黑名单校验");
    }
}
