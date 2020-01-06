package com.source.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author pengjw
 * @date 2019年10月11日 10:16
 * @description 切面
 * @Version 1.0
 */
@Component
@Aspect
public class SpringAspect {
    @Pointcut(value = "execution(* com.source.aop.controller.*.*(..))")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void before(JoinPoint joinPoint) {
        System.out.println("前置通知");
    }

    @After("pointcut()")
    public void after(JoinPoint joinPoint) {
        System.out.println("后置通知");
    }

    @AfterReturning(pointcut = "pointcut()", returning = "result")
    public void result(JoinPoint joinPoint, Object result) {
        System.out.println("返回通知:" + result);
    }
}
