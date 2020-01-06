package com.demo.cache;

/**
 * @author pengjw
 * @date 2019年09月29日 11:23
 * @description 缓存名称枚举类
 * @Version 1.0
 */
public enum Caches {
    query(9);

    Caches() {
    }

    Caches(int ttl) {
        this.ttl = ttl;
    }

    Caches(int ttl, int maxSize) {
        this.ttl = ttl;
        this.maxSize = maxSize;
    }

    /**
     * 最大數量
     */
    private static final int DEFAULT_MAXSIZE = 50000;
    /**
     * 过期时间（秒）
     */
    private static final int DEFAULT_TTL = 600;

    private int maxSize = DEFAULT_MAXSIZE;
    private int ttl = DEFAULT_TTL;

    public int getMaxSize() {
        return maxSize;
    }

    public int getTtl() {
        return ttl;
    }
    //endregion
}
