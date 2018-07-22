package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by zhong on 2018/5/9.
 */
@Data
@Entity
public class T_users {

    @Id
    private Integer uid;
    private String username;
    private String password;
    private String email;
    private String homeUrl;
    private String screenName;
    private Integer created;
    private Integer activated;
    private Integer logged;
    private String groupName;

}
