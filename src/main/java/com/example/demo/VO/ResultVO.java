package com.example.demo.VO;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by zhong on 2018/2/3.
 */
@Data
public class ResultVO<T> implements Serializable{

    private static final long serialVersionUID = -5866857696894938147L;
    /*错误码*/
    private Integer code;
    /*提示信息*/
    private String msg;
    /*具体内容*/
    private T data;

}
