package com.example.demo.service;

import com.example.demo.entity.T_comments;

import java.util.List;

/**
 * Created by zhong on 2018/5/21.
 */
public interface CommentsService {

    List<T_comments> selectComments(int limit);
}
