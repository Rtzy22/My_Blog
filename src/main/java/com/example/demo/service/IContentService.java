package com.example.demo.service;

import com.example.demo.entity.T_contents;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by zhong on 2018/6/26.
 */
public interface IContentService {

    /*
    分页获取文章列表
     */
    Page<T_contents> getArticlesWithpage(int page, int size);

    /*
    删除文章
     */
    String deleteByCid(Integer cid);

    T_contents getContents(String id);
}
