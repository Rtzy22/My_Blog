package com.example.demo.service.Impl;

import com.example.demo.entity.T_contents;
import com.example.demo.service.IContentService;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by zhong on 2018/6/26.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ContentServiceImplTest extends TestCase {

    @Autowired
    private IContentService service;


    @Test
    public void testGetArticlesWithpage() throws Exception {
        Page<T_contents> result = service.getArticlesWithpage(1, 10);
        Assert.assertNotEquals(null, result);
    }

    @Test
    public void testgetContents() throws Exception {
        T_contents result = service.getContents("1");
        Assert.assertNotEquals(null, result);
    }
}