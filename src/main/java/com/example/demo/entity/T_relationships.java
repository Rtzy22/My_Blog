package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by zhong on 2018/6/27.
 */
@Entity
@Data
public class T_relationships implements Serializable{

    private static final long serialVersionUID = -5647241311479478792L;

    @Id
    private Integer cid;

    private Integer mid;
}
