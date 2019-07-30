package com.aaa.microcredit.dao;

import com.aaa.microcredit.entity.Bondsman;
import org.springframework.stereotype.Repository;

@Repository
public interface BondsmanMapper {
    int deleteByPrimaryKey(Integer bId);

    int insert(Bondsman record);

    int insertSelective(Bondsman record);

    Bondsman selectByPrimaryKey(Integer bId);

    int updateByPrimaryKeySelective(Bondsman record);

    int updateByPrimaryKey(Bondsman record);
}