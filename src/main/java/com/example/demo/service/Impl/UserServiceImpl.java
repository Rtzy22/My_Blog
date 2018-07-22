package com.example.demo.service.Impl;

import com.example.demo.entity.T_users;
import com.example.demo.exception.TipException;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.utils.DataValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Created by zhong on 2018/5/9.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public T_users findByUid(Integer uid) {
        return userRepository.findOne(uid);
    }

    @Override
    public T_users login(String username, String password) {
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            throw new TipException("用户名或密码不能为空");
        }
        password = DataValidateUtil.MD5encode(username + password);
        T_users user = userRepository.findByUsername(username);
        if (user == null) {
            throw new TipException("用户不存在");
        } else {
            user = userRepository.findByUsernameAndPassword(username, password);
            if (user == null) {
                throw new TipException("密码错误！请重新输入！");
            }
        }
        return user;
    }

    @Override
    public String findUsernameByUid(Integer uid) {

        return userRepository.findUsernameByUid(uid).getUsername();
    }
}
