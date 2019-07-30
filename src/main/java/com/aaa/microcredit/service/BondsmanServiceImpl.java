package com.aaa.microcredit.service;

import com.aaa.microcredit.dao.BondsmanMapper;
import com.aaa.microcredit.entity.Bondsman;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BondsmanServiceImpl implements BondsmanService {
    @Autowired
    private BondsmanMapper Mapper;

    @Override
    public int deleteByPrimaryKey(Integer lawId) {
        return Mapper.deleteByPrimaryKey(lawId);
    }

    @Override
    public int insert(Bondsman record) {
        return Mapper.insert(record);
    }

    @Override
    public int insertSelective(Bondsman record) {
        return Mapper.insertSelective(record);
    }

    @Override
    public Bondsman selectByPrimaryKey(Integer lawId) {
        return Mapper.selectByPrimaryKey(lawId);
    }

    @Override
    public int updateByPrimaryKeySelective(Bondsman record) {
        return Mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Bondsman record) {
        return Mapper.updateByPrimaryKey(record);
    }
}
