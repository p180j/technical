package com.demo.cache;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.stats.CacheStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author pengjw
 * @date 2019年09月26日 20:01
 * @description 缓存
 * @Version 1.0
 */
@RestController
@RequestMapping("/cache")

public class CacheController {
    @Autowired
    private CacheService cacheService;
    @Autowired
    private CacheManager cacheManager;

    /**
     * 查询缓存的数量以及命中情况
     */
    @GetMapping("/cacheStatus")
    public List<HashMap<String, Object>> cacheStatu() {
        List<HashMap<String, Object>> collect = cacheManager.getCacheNames().stream().map(cache -> {
            Cache<Object, Object> nativeCache = ((CaffeineCache) cacheManager.getCache(cache)).getNativeCache();
            CacheStats cacheStats = nativeCache.stats();
            return new HashMap<String, Object>() {
                {
                    put("缓存名", cache);
                    put("命中率", cacheStats.requestCount());
                    put("命中次数", cacheStats.hitCount());
                    put("请求次数", cacheStats.requestCount());
                    put("驱逐次数", cacheStats.evictionCount());
                    put("驱逐权重", cacheStats.evictionWeight());
                    put("预估大小", nativeCache.estimatedSize());
                }

            };
        }).collect(Collectors.toList());
        return collect;
    }

    /**
     * Cacheable 根据id缓存
     */
    @GetMapping("/query")
    public UserInfo queryFromCache(@RequestParam("id") int id) {
        return cacheService.query(id);
    }

    /**
     * CacheEvict  删除缓存
     */
    @GetMapping("/del")
    public void delkey(@RequestParam("id") int id) {
        cacheService.delKey(id);
    }

    /**
     * Cacheable  缓存一个列表
     */
    @GetMapping("/list")
    public List<UserInfo> list() {
        return cacheService.list();
    }

    /**
     * unless  满足条件不缓存
     */
    @GetMapping("/unless")
    public UserInfo unless(@RequestParam("id") int id) {
        return cacheService.unless(id);
    }
}
