package com.example.demo.repository;

import com.example.demo.entity.T_users;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by zhong on 2018/5/9.
 */
public interface UserRepository extends JpaRepository<T_users, Integer> {

    T_users findByUsernameAndPassword(String username, String password);

    T_users findByUsername(String username);

    T_users findUsernameByUid(Integer uid);

}
