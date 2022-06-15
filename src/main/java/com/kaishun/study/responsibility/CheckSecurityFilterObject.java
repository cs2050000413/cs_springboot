package com.kaishun.study.responsibility;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Package: com.kaishun.study.responsibility
 * @ClassName: CheckSecurityFilterObject
 * @Author: zhoukaishun
 * @CreateTime: 2021/11/2 11:24
 * @Description: 参数安全性检查
 */
@Component
@Order(2)
public class CheckSecurityFilterObject extends AbstractHandler{
    @Override
    protected void doFilter(Object object) {
        System.out.println("参数安全性检查");
    }
}
