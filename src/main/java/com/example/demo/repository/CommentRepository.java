package com.example.demo.repository;

import com.example.demo.entity.T_comments;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by zhong on 2018/5/21.
 */
public interface CommentRepository extends JpaRepository<T_comments, Integer>{


}
