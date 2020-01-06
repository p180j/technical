package com.springCloud.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pengjw
 * @date 2019年03月21日 16:44
 * @description springCloudConfigClient测试
 * @Version 1.0
 * @Value("${neo.hello}") neo.hello是文件中的属性名
 */
@RestController
public class SpringCloudConfClient {

    @Value("${neo.hello}")
    private String hello;

    @RequestMapping("/hello")
    public String from() {
        return this.hello;
    }

}
