package com.example.demo.service.Impl;

import com.example.demo.service.SerletTest;
import org.springframework.stereotype.Service;

/**
 * Created by zhong on 2018/6/30.
 */
@Service("my_blog_fake")
public class SerletTestImpl implements SerletTest {
    @Override
    public String getMsg() {
        return "狗粉丝滚出克!";
    }
}
