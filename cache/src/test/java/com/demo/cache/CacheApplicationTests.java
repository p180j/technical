package com.demo.cache;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CacheApplicationTests {

    @Autowired
    private CacheService cacheService;


    @Test
    public void test() {
        System.out.println("第一次查询，使用初始化........");
        System.out.println(cacheService.list());
        System.out.println("第二次查询,是否使用缓存.......");
        System.out.println(cacheService.list());
    }

}
