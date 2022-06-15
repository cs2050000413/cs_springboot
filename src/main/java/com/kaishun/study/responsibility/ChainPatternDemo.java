package com.kaishun.study.responsibility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

/**
 * @Package: com.kaishun.study.responsibility
 * @ClassName: ChainPatternDemo
 * @Author: zhoukaishun
 * @CreateTime: 2021/11/2 11:26
 * @Description:
 */
@Component
public class ChainPatternDemo {

    /**
     * 自动注入各个责任链的对象
     */
    @Resource
    private List<AbstractHandler> abstractHandleList;

    private AbstractHandler abstractHandler;


    @PostConstruct
    public void initializeChainFilter(){

        for(int i = 0;i<abstractHandleList.size();i++){
            if(i == 0){
                abstractHandler = abstractHandleList.get(0);
            }else{
                AbstractHandler currentHandler = abstractHandleList.get(i - 1);
                AbstractHandler nextHandler = abstractHandleList.get(i);
                currentHandler.setNextHandler(nextHandler);
            }
        }
    }

    /**
     * 直接调用这个方法使用
     * @param object
     */
    public void exec(Object object) {
        abstractHandler.filter(object);
    }

}
