package com.example.demo.service.Impl;

import com.example.demo.repository.RelationshipsRepository;
import com.example.demo.service.RelationshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhong on 2018/6/27.
 */
@Service
public class RelationshipServiceImpl implements RelationshipService {

    @Autowired
    private RelationshipsRepository repository;

    @Override
    public int deleteByCidAndMid(Integer cid, Integer mid) {
        int n = -1;
        if (null != cid && mid != null) {
            repository.deleteByCidAndMid(cid, mid);
            n = 0;
        }else if (null != cid) {
            repository.deleteByCidAndMid(cid);
            n = 0;
        }
        return n;
    }
}
