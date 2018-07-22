package com.example.demo.constant;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhong on 2018/5/9.
 */
@Component
public class WebConst {

    public static Map<String, String> initConfig = new HashMap<>();

    public static String LOGIN_SESSION_KEY = "login_user";

    public static String USER_IN_COOKIE = "S_L_ID";

    /**
     * 成功返回
     */
    public static String SUCCESS_RESULT = "SUCCESS";


}
