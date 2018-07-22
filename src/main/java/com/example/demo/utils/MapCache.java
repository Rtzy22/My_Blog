package com.example.demo.utils;

import lombok.Getter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * map缓存实现
 * Created by zhong on 2018/5/16.
 */
public class MapCache {

    //ConcurrentHashMap 的默认分段锁空间,默认锁空间为1024
    private static final int DEFALUT_CACHES = 1024;

    // 饿汉模式 初始化时创建实例， 保证线程安全
    private static final MapCache INS = new MapCache();

    private Map<String, Object> cachePool;

    // MapCache 的单例，获取cachePool， 锁空间为 1024
    public static MapCache single() {
        return INS;
    }

    public MapCache() {
        this(DEFALUT_CACHES);
    }

    public MapCache(int size) {
        cachePool = new ConcurrentHashMap<>(size);
    }

    /**
     * 缓存对象
     */
    @Getter
    static class CacheObject{

        private String key;
        private Object value;
        private long expired;

        public CacheObject(String key, Object value, long expired) {
            this.key = key;
            this.value = value;
            this.expired = expired;
        }
    }

    /*
    读取一个http缓存
     */
    public <T> T get(String key) {
        CacheObject cacheObject = (CacheObject) cachePool.get(key);
        if (cacheObject != null) {
            long currentTime = System.currentTimeMillis() / 1000;
            // 如果当前缓存的值大于当前时间，则返回结果
            if (cacheObject.getExpired() <= 0 || cacheObject.getExpired() > currentTime) {
                Object result = cacheObject.getValue();
                return (T) result;
            }

            // 如果当前缓存已过期，则删除缓存
            if (cacheObject.getExpired() < currentTime) {
                cachePool.remove(key);
            }
        }
        return null;
    }

    /*
    设置一个http缓存
     */
    public void set(String Key, Object value, long expired) {
        expired = expired > 0 ? System.currentTimeMillis() / 1000 + expired : expired;

        //cachePool大于800时，强制清空缓存池，这个操作有些粗暴会导致误删问题，后期考虑用redis替代MapCache优化
        if (cachePool.size() > 800) {
            cachePool.clear();
        }
        CacheObject cacheObject = new CacheObject(Key, value, expired);
        cachePool.put(Key, cacheObject);
    }
}
