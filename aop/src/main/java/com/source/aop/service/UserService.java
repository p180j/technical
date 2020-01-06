package com.source.aop.service;

import com.source.aop.User;

import java.util.List;

/**
 * @author pengjw
 * @date 2019年10月11日 10:22
 * @description 业务层
 * @Version 1.0
 */
public interface UserService {

    List<User> list();

    void jdkTest();
}
