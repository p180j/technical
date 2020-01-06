package com.source.aop;

import lombok.Data;

/**
 * @author pengjw
 * @date 2019年10月11日 10:21
 * @description 用户
 * @Version 1.0
 */
@Data
public class User {
    private String name;
    private Integer age;

    public void studying(String args) {
        System.out.println("学生要学习" + args);
    }

    private void sleep(String name) {
        System.out.println(name + "正在偷偷睡觉...");
    }
}
