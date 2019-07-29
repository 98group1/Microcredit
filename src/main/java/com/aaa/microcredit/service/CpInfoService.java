package com.aaa.microcredit.service;

import com.aaa.microcredit.entity.CpInfo;

public interface CpInfoService {
    int deleteByPrimaryKey(Integer cpId);

    int insert(CpInfo record);

    int insertSelective(CpInfo record);

    CpInfo selectByPrimaryKey(Integer cpId);

    int updateByPrimaryKeySelective(CpInfo record);

    int updateByPrimaryKey(CpInfo record);
}
