package com.demo.cache;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author pengjw
 * @date 2019年09月27日 17:09
 * @description cache配置类
 * @Version 1.0
 */
@Configuration
@EnableCaching
public class CacheConfig {
    @Autowired
    private CaffeineCacheProperties properties;

    @Bean
    public CacheManager caffeineCacheManager() {
        List<CaffeineCache> caches = Lists.newArrayList();
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        if (!CollectionUtils.isEmpty(properties.getItem())) {
            properties.getItem().forEach(i -> {
                CaffeineCache cache;
                if (i.getRecordStats()) {
                    cache = new CaffeineCache(i.getCacheNames(), Caffeine.newBuilder()
                            .recordStats()
                            .expireAfterWrite(i.getExpireSeconds(), TimeUnit.SECONDS)
                            .initialCapacity(i.getInitSize())
                            .maximumSize(i.getMaxSize())
                            .build());
                } else {
                    cache = new CaffeineCache(i.getCacheNames(), Caffeine.newBuilder()
                            .expireAfterWrite(i.getExpireSeconds(), TimeUnit.SECONDS)
                            .initialCapacity(i.getInitSize())
                            .maximumSize(i.getMaxSize())
                            .build());
                }
                caches.add(cache);
            });
            cacheManager.setCaches(caches);
        }
/*        for (Caches c : Caches.values()) {
            caches.add(new CaffeineCache(c.name(),
                    Caffeine.newBuilder()
                            .softValues()
                            .recordStats()
                            .expireAfterWrite(c.getTtl(), TimeUnit.SECONDS)
                            .maximumSize(c.getMaxSize())
                            .build())
            );

        }
        cacheManager.setCaches(caches);*/
        return cacheManager;
    }

}
