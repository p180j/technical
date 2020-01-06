package com.source.aop.controller;

import com.source.aop.User;
import com.source.aop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author pengjw
 * @date 2019年10月11日 10:20
 * @description 控制器
 * @Version 1.0
 */
@RestController
public class ApoController {
    @Autowired
    UserService userService;

    @RequestMapping("/list")
    public List<User> list() {
        return userService.list();
    }

}
