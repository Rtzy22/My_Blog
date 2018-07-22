package com.example.demo.controller;

import com.example.demo.utils.MapCache;

/**
 * Created by zhong on 2018/5/16.
 */
public abstract class BaseController {

    // 初始化一个缓存容器
    protected MapCache cache = MapCache.single();
}
