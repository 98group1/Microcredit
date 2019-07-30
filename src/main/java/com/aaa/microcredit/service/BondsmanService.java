package com.aaa.microcredit.service;

public interface BondsmanService {
    int deleteByPrimaryKey(Integer bId);

    int insert(Bondsman record);

    int insertSelective(Bondsman record);

    Bondsman selectByPrimaryKey(Integer bId);

    int updateByPrimaryKeySelective(Bondsman record);

    int updateByPrimaryKey(Bondsman record);
}
