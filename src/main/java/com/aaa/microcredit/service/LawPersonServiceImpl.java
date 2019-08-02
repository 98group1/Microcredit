package com.aaa.microcredit.service;

import com.aaa.microcredit.dao.LawPersonMapper;
import com.aaa.microcredit.entity.LawPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LawPersonServiceImpl implements LawPersonService {
    @Autowired
    private LawPersonMapper Mapper;
    @Override
    public int deleteByPrimaryKey(Integer lawId) {
        return Mapper.deleteByPrimaryKey(lawId);
    }

    @Override
    public int insert(LawPerson record) {
        return Mapper.insert(record);
    }

    @Override
    public int insertSelective(LawPerson record) {
        return Mapper.insertSelective(record);
    }

    @Override
    public LawPerson selectByPrimaryKey(Integer lawId) {
        return Mapper.selectByPrimaryKey(lawId);
    }

    @Override
    public int updateByPrimaryKeySelective(LawPerson record) {
        return Mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(LawPerson record) {
        return Mapper.updateByPrimaryKey(record);
    }
}
