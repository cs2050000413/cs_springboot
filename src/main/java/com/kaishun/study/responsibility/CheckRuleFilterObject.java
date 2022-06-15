package com.kaishun.study.responsibility;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Package: com.kaishun.study.responsibility
 * @ClassName: CheckRuleFilterObject
 * @Author: zhoukaishun
 * @CreateTime: 2021/11/2 11:25
 * @Description: 参数规则校验
 */
@Component
@Order(4)
public class CheckRuleFilterObject extends AbstractHandler{
    @Override
    protected void doFilter(Object object) {
        System.out.println("参数规则校验");
    }
}
