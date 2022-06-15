package com.kaishun.study.responsibility;

/**
 * @Package: com.kaishun.study.responsibility
 * @ClassName: AbstractHandler
 * @Author: zhoukaishun
 * @CreateTime: 2021/11/2 11:17
 * @Description:
 */
public abstract class AbstractHandler {
    /**
     * 责任链中的下一个对象
     */
    private AbstractHandler nextHandler;

    /**
     * 责任链的下一个对象
     */
    public void setNextHandler(AbstractHandler nextHandler){
        this.nextHandler = nextHandler;
    }

    /**
     * 具体参数拦截逻辑,给子类去实现
     */
    public void filter(Object object) {
        doFilter(object);
        if (getNextHandler() != null) {
            getNextHandler().filter(object);
        }
    }

    protected AbstractHandler getNextHandler(){
        return nextHandler;
    }

    /**
     * 逻辑实现给子类
     * @param object
     */
    protected abstract void doFilter(Object object);

}
