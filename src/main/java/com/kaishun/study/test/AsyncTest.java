package com.kaishun.study.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @Package: com.kaishun.study.test
 * @ClassName: AsyncTest
 * @Author: zhoukaishun
 * @CreateTime: 2022/5/31 17:48
 * @Description:
 */
@Component
@Slf4j
public class AsyncTest {

    @Async
    public void test(){
        log.info("进入test方法");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("test方法结束");
    }

    @Async
    public void test2(){
        log.info("进入test2方法");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("test2方法结束");
    }

}
