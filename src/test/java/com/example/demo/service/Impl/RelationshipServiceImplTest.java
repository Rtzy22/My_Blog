package com.example.demo.service.Impl;

import com.example.demo.service.RelationshipService;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by zhong on 2018/6/28.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RelationshipServiceImplTest extends TestCase {

    @Autowired
    private RelationshipService relationshipService;

    @Test
    public void testDeleteById() throws Exception {
        int result = relationshipService.deleteByCidAndMid(2, null);
        Assert.assertNotEquals(-1, result);
    }
}