package com.source.aop.interce;


import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author pengjw
 * @date 2019年10月11日 10:44
 * @description 回调函数
 * @Version 1.0
 */

public class TargetInterceptor implements MethodInterceptor {


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("回调方法调用前......");
        Object o1 = methodProxy.invokeSuper(o, objects);
        System.out.println("" +
                "回调方法调用后......");
        return o1;
    }
}
