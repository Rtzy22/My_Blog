package com.example.demo.service.Impl;

import com.example.demo.entity.T_users;
import com.example.demo.service.UserService;
import com.example.demo.utils.DataValidateUtil;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by zhong on 2018/5/9.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest extends TestCase {

    @Autowired
    private UserService userService;

    @Test
    public void testFindByUid() throws Exception {
        T_users result = userService.findByUid(1);
        Assert.assertNotEquals(null, result);
    }

    @Test
    public void testFindByUsernameAndPassword() throws Exception {
        String username = "admin";
        String password = "123456";
        String _password = DataValidateUtil.MD5encode(username + password);
        T_users result = userService.login(username, _password);
        Assert.assertNotEquals(null, result);
    }

    @Test
    public void testFindUsernameByUid() throws Exception {
        Integer uid = 1;
        String result = userService.findUsernameByUid(uid);
        Assert.assertNotEquals(null, result);
    }
}