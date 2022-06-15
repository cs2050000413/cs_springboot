package com.kaishun.study.responsibility;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;



/**
 * @Package: com.kaishun.study.responsibility
 * @ClassName: CheckParamFilterObject
 * @Author: zhoukaishun
 * @CreateTime: 2021/11/2 11:22
 * @Description: 校验参数的实现
 */
@Component
@Order(1)
public class CheckParamFilterObject extends AbstractHandler{
    @Override
    protected void doFilter(Object object) {
        System.out.println("参数合理性检查");
    }
}
