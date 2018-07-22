package com.example.demo.repository;

import com.example.demo.entity.T_relationships;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/**
 * Created by zhong on 2018/6/27.
 */
public interface RelationshipsRepository extends JpaRepository<T_relationships, Integer> {

    @Modifying
    @Transactional
    @Query(value = "delete from t_relationships where cid = ?1 and mid = ?2", nativeQuery = true)
    void deleteByCidAndMid(Integer cid, Integer mid);


    @Modifying
    @Transactional
    @Query(value = "delete from t_relationships where cid = ?1", nativeQuery = true)
    void deleteByCidAndMid(Integer cid);
}
