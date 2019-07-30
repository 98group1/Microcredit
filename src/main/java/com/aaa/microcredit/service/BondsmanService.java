package com.aaa.microcredit.service;

import com.aaa.microcredit.entity.Bondsman;
import com.aaa.microcredit.entity.LawPerson;

public interface BondsmanService {
    int deleteByPrimaryKey(Integer bId);

    int insert(Bondsman record);

    int insertSelective(Bondsman record);

    Bondsman selectByPrimaryKey(Integer bId);

    int updateByPrimaryKeySelective(Bondsman record);

    int updateByPrimaryKey(Bondsman record);
}
