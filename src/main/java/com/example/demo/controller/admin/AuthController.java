package com.example.demo.controller.admin;

import com.example.demo.VO.ResultVO;
import com.example.demo.constant.WebConst;
import com.example.demo.controller.BaseController;
import com.example.demo.entity.T_users;
import com.example.demo.exception.TipException;
import com.example.demo.service.UserService;
import com.example.demo.utils.ResultVOUtil;
import com.example.demo.utils.TaleUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by zhong on 2018/5/9.
 */
@Controller
@RequestMapping("/admin")
@Slf4j
public class AuthController extends BaseController{

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "admin/login";
    }

    @GetMapping("")
    public String index() {
        return "admin/index";
    }

    @PostMapping("login")
    @ResponseBody
    public ResultVO doLogin(@RequestParam String username,
                            @RequestParam String password,
                            @RequestParam(required = false) String remeber_me,
                            HttpServletRequest request,
                            HttpServletResponse response) {

        Integer error_count = cache.get("login_error_count");
        if (error_count != null && error_count > 3) {
            return ResultVOUtil.error("你输入的密码错误超过了3次，请10分钟后尝试！");
        }

        try {
            T_users user = userService.login(username, password);
            request.getSession().setAttribute(WebConst.LOGIN_SESSION_KEY, user);
            System.out.println(request.getSession().getAttribute(WebConst.LOGIN_SESSION_KEY));
            // 设置记住登录状态的 Cookie
            if (!StringUtils.isEmpty(remeber_me)) {
                TaleUtils.setUidCookie(response, user.getUid());
            }

            return ResultVOUtil.success();
        } catch (Exception e) {
            error_count = error_count == null ? 1 : error_count + 1;

            cache.set("login_error_count", error_count, 60 * 10);
            if (error_count > 3) {
                return ResultVOUtil.error("你输入的密码错误超过了3次，请10分钟后尝试！");
            }
            String msg = "【登录失败】";

            if (e instanceof TipException) {
                msg = e.getMessage() + "exception: = {}";
            }
            log.error(msg, e);
            return ResultVOUtil.error(e.getMessage());
        }

        // 记录登录日志

//            return ResultVOUtil.success();

    }

    @RequestMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.removeAttribute(WebConst.LOGIN_SESSION_KEY);
        Cookie cookie = new Cookie(WebConst.USER_IN_COOKIE, null);
        // 销毁记住密码的Cookie
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);

        try {
            response.sendRedirect("/admin/login");
        } catch (IOException e) {
//            e.printStackTrace();
            log.error("注销失败！", e.getMessage());
        }

    }
}
