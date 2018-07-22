package com.example.demo.service;

import com.example.demo.entity.T_metas;

import java.util.List;

/**
 * Created by zhong on 2018/6/28.
 */
public interface MetaService {

    List<T_metas> getMetas(String types);
}
