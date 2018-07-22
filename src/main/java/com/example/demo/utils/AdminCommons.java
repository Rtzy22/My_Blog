package com.example.demo.utils;

import com.example.demo.entity.T_metas;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Created by zhong on 2018/6/28.
 */
@Component
public class AdminCommons {

    public static boolean exist_cat(T_metas metas, String cats) {
        String [] arr = StringUtils.split(cats, ",");
        if (null != arr && arr.length > 0)
        for (String s : arr) {
            if (s.trim().equals(metas.getName())) {
                return true;
            }
        }

        return false;

    }
}
