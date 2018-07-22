package com.example.demo.service.Impl;

import com.example.demo.constant.WebConst;
import com.example.demo.entity.T_comments;
import com.example.demo.entity.T_contents;
import com.example.demo.repository.ContentRepository;
import com.example.demo.service.IContentService;
import com.example.demo.service.RelationshipService;
import com.example.demo.utils.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;

/**
 * Created by zhong on 2018/6/26.
 */
@Service
public class ContentServiceImpl implements IContentService {

    @Autowired
    private ContentRepository repository;

    @Autowired
    private RelationshipService relationshipService;

    @Override
    public Page<T_contents> getArticlesWithpage(int page, int size) {
        Sort sort = new Sort(Sort.Direction.DESC, "modified");
        Pageable pageable = new PageRequest(page, size, sort);
        Page<T_contents> result = repository.findAll(pageable);

        return result;
    }

    @Override
    @Transactional
    public String deleteByCid(Integer cid) {
        if (null != cid) {
            repository.delete(cid);
            relationshipService.deleteByCidAndMid(cid, null);
            return WebConst.SUCCESS_RESULT;
        }

        return "数据为空";
    }

    @Override
    public T_contents getContents(String id) {
        if (!StringUtils.isEmpty(id)) {
            if (Tools.isNumber(id)) {
                T_contents t_contents = repository.findOne(Integer.parseInt(id));
                return t_contents;
            }
        }
        return null;
    }
}
