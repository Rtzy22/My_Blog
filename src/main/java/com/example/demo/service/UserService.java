package com.example.demo.service;

import com.example.demo.entity.T_users;

/**
 * Created by zhong on 2018/5/9.
 */
public interface UserService {
    T_users findByUid(Integer uid);

    T_users login(String username, String password);

    String findUsernameByUid(Integer uid);

}
