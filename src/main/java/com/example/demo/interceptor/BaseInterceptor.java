package com.example.demo.interceptor;

import com.example.demo.constant.WebConst;
import com.example.demo.entity.T_users;
import com.example.demo.service.UserService;
import com.example.demo.utils.AdminCommons;
import com.example.demo.utils.Commons;
import com.example.demo.utils.IPKit;
import com.example.demo.utils.TaleUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhong on 2018/5/16.
 */
@Component
@Slf4j
public class BaseInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    private static final String USER_AGENT = "user-agent";

    @Autowired
    private Commons commons;

    @Autowired
    private AdminCommons adminCommons;

    /*
    发生在请求开始前
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String uri = request.getRequestURI();

        log.info("UserAgent: {}", request.getHeader(USER_AGENT));   // 记录访问用户的操作系统
        log.info("用户访问url: {}, 用户地址: {}", uri, IPKit.getIpAddrByRequest(request));     // 记录用户IP

        // 请求拦截处理
        T_users user = TaleUtils.getLoginUser(request);
        if (user == null) {
            Integer uid = TaleUtils.getUidCookie(request);
            if (uid != null) {
                //这里还是有安全隐患,cookie是可以伪造的
                user = userService.findByUid(uid);
                request.getSession().setAttribute(WebConst.LOGIN_SESSION_KEY, user);
            }
        }

        // 拦截未登录的请求，返回登录页
        if (uri.startsWith("/admin") && !uri.startsWith("/admin/login") && user == null) {
            response.sendRedirect(request.getContextPath() + "/admin/login");
            return false;
        }

        // 设置记住登录状态 Cookie
//        if (request.getMethod().equals("GET")) {
//
//        }

        return true;
    }

    /*
    发生请求结束后，返回结果前
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {
        request.setAttribute("commons", commons);
        request.setAttribute("adminCommons", adminCommons);

    }

    /*
    在请求结束返回结果后开始执行
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
