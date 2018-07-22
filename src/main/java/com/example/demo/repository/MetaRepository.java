package com.example.demo.repository;

import com.example.demo.entity.T_metas;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by zhong on 2018/6/28.
 */
public interface MetaRepository extends JpaRepository<T_metas, Integer> {

}
