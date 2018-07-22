package com.example.demo.service.Impl;

import com.example.demo.entity.T_comments;
import com.example.demo.repository.CommentRepository;
import com.example.demo.service.ISiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * Created by zhong on 2018/5/21.
 */
public class ISiteServiceImpl implements ISiteService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<T_comments> recentComments(int limit) {
        Sort sort = new Sort(Sort.Direction.DESC, "coid");
        PageRequest request = new PageRequest(1, 10, sort);
        List<T_comments> list = commentRepository.findAll(sort);
        return null;
    }
}
