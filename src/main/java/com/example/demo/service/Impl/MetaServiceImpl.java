package com.example.demo.service.Impl;

import com.example.demo.entity.T_metas;
import com.example.demo.repository.MetaRepository;
import com.example.demo.service.MetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by zhong on 2018/6/28.
 */
@Service
public class MetaServiceImpl implements MetaService {

    @Autowired
    private MetaRepository metaRepository;

    @Override
    public List<T_metas> getMetas(String types) {
        if (!StringUtils.isEmpty(types)) {
            Sort sort = new Sort(Sort.Direction.DESC, "sort", "mid");
            List<T_metas> t_metases = metaRepository.findAll(sort);
            return t_metases;
        }
        return null;
    }
}
