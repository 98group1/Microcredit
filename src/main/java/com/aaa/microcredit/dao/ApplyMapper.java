package com.aaa.microcredit.dao;

import com.aaa.microcredit.entity.Apply;

public interface ApplyMapper {
    int deleteByPrimaryKey(Integer applyId);

    int insert(Apply record);

    int insertSelective(Apply record);

    Apply selectByPrimaryKey(Integer applyId);

    int updateByPrimaryKeySelective(Apply record);

    int updateByPrimaryKey(Apply record);
}