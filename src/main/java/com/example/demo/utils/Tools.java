package com.example.demo.utils;

/**
 * Created by zhong on 2018/5/17.
 */
public class Tools {

    public static boolean isNumber(String val) {
        if (val != null && val.trim().length() != 0 && val.matches("\\d*")) {
            return true;
        }
        return false;
    }

}
