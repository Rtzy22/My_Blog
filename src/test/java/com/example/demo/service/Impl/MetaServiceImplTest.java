package com.example.demo.service.Impl;

import com.example.demo.entity.T_metas;
import com.example.demo.service.MetaService;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by zhong on 2018/6/28.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MetaServiceImplTest extends TestCase {

    @Autowired
    private MetaService metaService;

    @Test
    public void testGetMetas() throws Exception {
        List<T_metas> result = metaService.getMetas("category");
        Assert.assertNotEquals(0, result.size());
    }
}