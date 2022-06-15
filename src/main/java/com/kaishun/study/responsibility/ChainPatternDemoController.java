package com.kaishun.study.responsibility;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Package: com.kaishun.study.responsibility
 * @ClassName: TestController
 * @Author: zhoukaishun
 * @CreateTime: 2021/11/2 11:28
 * @Description:
 */
@RestController
public class ChainPatternDemoController {


    @Resource
    private ChainPatternDemo chainPatternDemo;

    @GetMapping("chainPatternDemo")
    public void test(){
        chainPatternDemo.exec(new Object());
    }

}
