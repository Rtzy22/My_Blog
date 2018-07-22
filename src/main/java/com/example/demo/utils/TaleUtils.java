package com.example.demo.utils;

import com.example.demo.constant.WebConst;
import com.example.demo.entity.T_users;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by zhong on 2018/5/16.
 */
@Slf4j
public class TaleUtils {

    /**
     * 获取当前登录的用户
     * @param request
     * @return
     */
    public static T_users getLoginUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session != null) {
            return (T_users) session.getAttribute(WebConst.LOGIN_SESSION_KEY);
        }
        return null;
    }

    /*
    获取Cookie中的uid
     */
    public static Integer getUidCookie(HttpServletRequest request) {
        if (request != null) {
            Cookie cookie = cookieRaw(request, WebConst.USER_IN_COOKIE);
            if (cookie != null) {
                return Tools.isNumber(cookie.getValue()) ? Integer.parseInt(cookie.getValue()) : null;
            }
        }
        return null;
    }

    /*
    匹配Cookie数组中符合的cookie实例
     */
    private static Cookie cookieRaw(HttpServletRequest request, String name) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (name.equals(cookie.getName())) {
                return cookie;
            }
        }
        return null;
    }

    /**
     * 设置cookie信息
     * @param response
     * @param uid
     */
    public static void setUidCookie(HttpServletResponse response, Integer uid) {
        try {
            boolean isSSL = false;
            Cookie cookie = new Cookie(WebConst.USER_IN_COOKIE, uid.toString());
            cookie.setMaxAge(30 * 60);
            cookie.setPath("/");
            cookie.setSecure(isSSL);

            response.addCookie(cookie);
        } catch (Exception e) {
            log.error("【cookie设置错误！cookie={}】");
        }
    }

    /**
     * md5加密
     *
     * @param source 数据源
     * @return 加密字符串
     */
    public static String MD5encode(String source) {
        if (StringUtils.isEmpty(source)) {
            return null;
        }
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] encode = messageDigest.digest(source.getBytes());
        StringBuilder hexString = new StringBuilder();

        for (byte anEncode : encode) {
            String hex = Integer.toHexString(0xff & anEncode);
            if (hex.length() == 1) {
                hexString.append('0');

            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
