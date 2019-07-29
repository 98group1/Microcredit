package com.aaa.microcredit.dao;

import com.aaa.microcredit.entity.CpInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface CpInfoMapper {
    int deleteByPrimaryKey(Integer cpId);

    int insert(CpInfo record);

    int insertSelective(CpInfo record);

    CpInfo selectByPrimaryKey(Integer cpId);

    int updateByPrimaryKeySelective(CpInfo record);

    int updateByPrimaryKey(CpInfo record);
}