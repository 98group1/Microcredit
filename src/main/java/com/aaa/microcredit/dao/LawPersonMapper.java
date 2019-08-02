package com.aaa.microcredit.dao;

import com.aaa.microcredit.entity.LawPerson;
import org.springframework.stereotype.Repository;

@Repository
public interface LawPersonMapper {
    int deleteByPrimaryKey(Integer lawId);

    int insert(LawPerson record);

    int insertSelective(LawPerson record);

    LawPerson selectByPrimaryKey(Integer lawId);

    int updateByPrimaryKeySelective(LawPerson record);

    int updateByPrimaryKey(LawPerson record);
}