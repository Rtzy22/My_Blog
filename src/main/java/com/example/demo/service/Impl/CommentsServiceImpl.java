package com.example.demo.service.Impl;

import com.example.demo.entity.T_comments;
import com.example.demo.repository.CommentRepository;
import com.example.demo.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by zhong on 2018/5/21.
 */
public class CommentsServiceImpl implements CommentsService{

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<T_comments> selectComments(int limit) {
        return commentRepository.findAll();
    }
}
