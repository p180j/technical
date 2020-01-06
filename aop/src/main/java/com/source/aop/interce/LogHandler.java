package com.source.aop.interce;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author pengjw
 * @date 2019年10月15日 20:11
 * @description
 * @Version 1.0
 */

public class LogHandler implements InvocationHandler {
    Object target;  // 被代理的对象，实际的方法执行者

    public LogHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("jdk动态代理调用前.........");
        Object invoke = method.invoke(target, args);
        System.out.println("jdk动态代理调用后.........");
        return invoke;
    }
}
