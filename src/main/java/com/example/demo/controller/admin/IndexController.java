package com.example.demo.controller.admin;

import com.example.demo.controller.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhong on 2018/5/21.
 */
@Controller
@RequestMapping("/home")
@Slf4j
public class IndexController extends BaseController{



    @GetMapping({"", "/index"})
    public String home(HttpServletRequest request) {
        log.info("Enter admin index method");



        log.info("Exit admin index method");

        return null;
    }
}
