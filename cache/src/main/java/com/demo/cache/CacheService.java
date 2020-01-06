package com.demo.cache;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author pengjw
 * @date 2019年09月26日 20:19
 * @description
 * @Version 1.0
 */

@Service
public class CacheService {

    private Map<Integer, UserInfo> userMap = new HashMap<Integer, UserInfo>();

    /**
     * 初始化一波信息
     */
    public CacheService() {
        UserInfo u1 = new UserInfo();
        u1.setId(1);
        u1.setName("1111");
        UserInfo u2 = new UserInfo();
        u2.setId(2);
        u2.setName("222");
        UserInfo u3 = new UserInfo();
        u3.setId(3);
        u3.setName("333");
        userMap.put(1, u1);
        userMap.put(2, u2);
        userMap.put(3, u3);
    }


    @Cacheable(value = "add")
    public List<UserInfo> list() {
        System.out.println("调用方法查询数据.....");
        UserInfo[] users = new UserInfo[userMap.size()];
        this.userMap.values().toArray(users);
        return Arrays.asList(users);
    }


    @Cacheable(cacheNames = "query", key = "#root.methodName")
    public UserInfo query(int id) {
        System.out.println("查询数据通过方法获取.....");
        UserInfo userInfo = userMap.get(id);
        return userInfo;
    }

    @CacheEvict(cacheNames = "query", key = "#id")
    public void delKey(int id) {
        System.out.println("开始根据id清空缓存.....");

    }

    @Cacheable(cacheNames = "query", unless = "#id > 2")
    public UserInfo unless(int id) {
        System.out.println("如果id大于2就不缓存......");
        UserInfo userInfo = userMap.get(id);
        return userInfo;
    }

}
