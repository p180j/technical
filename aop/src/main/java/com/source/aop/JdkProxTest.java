package com.source.aop;

import com.source.aop.interce.LogHandler;
import com.source.aop.service.UserService;
import com.source.aop.service.impl.UserServiceImpl;
import com.sun.deploy.net.proxy.ProxyUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author pengjw
 * @date 2019年10月15日 20:23
 * @description jdk动态代理
 * @Version 1.0
 */

public class JdkProxTest {
    public static void main(String[] args) {
        UserServiceImpl userServiceImpl = new UserServiceImpl();
        ClassLoader classLoader = userServiceImpl.getClass().getClassLoader();
        Class<?>[] interfaces = userServiceImpl.getClass().getInterfaces();
        InvocationHandler invocationHandler = new LogHandler(userServiceImpl);
        UserService prox = (UserService) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        prox.jdkTest();
        //获取jdk动态生成的源码
        JDKProxyUtils.generateClassFile(userServiceImpl.getClass(), "UserServiceProxy");
    }


}
