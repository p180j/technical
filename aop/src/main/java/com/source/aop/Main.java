package com.source.aop;

import com.source.aop.interce.TargetInterceptor;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;


/**
 * @author pengjw
 * @date 2019年10月11日 10:55
 * @description 测试
 * @Version 1.0
 */

public class Main {

    public static void main(String[] args) throws IOException {
        //创建字节码增强器
        Enhancer enhancer = new Enhancer();
        //设置父类
        enhancer.setSuperclass(User.class);
        //设置回调函数
        enhancer.setCallback(new TargetInterceptor());
        //创建代理类
        User user = (User) enhancer.create();
        // user.studying("数学");
        try {
            Method studying = user.getClass().getMethod("studying", String.class);
            studying.invoke(user, "语文");
            // 因为sleep是user的私有方法，所以代理类中无法使用，会报错 java.lang.NoSuchMethodException: com.source.aop.User$$EnhancerByCGLIB$$6f96c8aa.sleep(java.lang.String)
           /* Method sleep = user.getClass().getMethod("sleep", String.class);
            sleep.invoke(user,"小明");*/
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        // System.in.read();
        AtomicInteger atomicInteger = new AtomicInteger();
        int i = atomicInteger.intValue();
        System.out.println(i);

    }


}
