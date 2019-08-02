package com.aaa.microcredit.service;

import com.aaa.microcredit.entity.LawPerson;

public interface LawPersonService {
    int deleteByPrimaryKey(Integer lawId);

    int insert(LawPerson record);

    int insertSelective(LawPerson record);

    LawPerson selectByPrimaryKey(Integer lawId);

    int updateByPrimaryKeySelective(LawPerson record);

    int updateByPrimaryKey(LawPerson record);
}
