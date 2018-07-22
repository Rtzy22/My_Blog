package com.example.demo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhong on 2018/6/26.
 */
public class DateKit {

    public static String formatDateByUnixTime(long unixTime, String dateFormat) {
        return dateFormat(new Date(unixTime * 1000L), dateFormat);
    }

    public static String dateFormat(Date date) {
        return dateFormat(date, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 日期格式化类
     * @param date 日期
     * @param dateFormat 日期的格式
     * @return
     */
    public static String dateFormat(Date date, String dateFormat) {
        if (date != null) {
            SimpleDateFormat format = new SimpleDateFormat(dateFormat);
            if (date != null) {
                return format.format(date);
            }
        }
        return "";
    }
}
