package com.source.aop.service.impl;

import com.source.aop.User;
import com.source.aop.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pengjw
 * @date 2019年10月11日 10:22
 * @description 业务实现
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public List<User> list() {
        List<User> list = new ArrayList<>();
        User user1 = new User();
        user1.setName("1");
        user1.setAge(1);
        User user2 = new User();
        user2.setName("2");
        user2.setAge(2);
        list.add(user1);
        list.add(user2);
        return list;
    }

    @Override
    public void jdkTest() {
        System.out.println("Jdk执行动态代理");
    }
}
