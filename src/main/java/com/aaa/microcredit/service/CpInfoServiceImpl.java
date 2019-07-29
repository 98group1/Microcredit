package com.aaa.microcredit.service;

import com.aaa.microcredit.dao.CpInfoMapper;
import com.aaa.microcredit.entity.CpInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CpInfoServiceImpl implements CpInfoService {
    @Autowired
    private CpInfoMapper cpInfoMapper;
    @Override
    public int deleteByPrimaryKey(Integer cpId) {
        return cpInfoMapper.deleteByPrimaryKey(cpId);
    }

    @Override
    public int insert(CpInfo record) {
        return cpInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(CpInfo record) {
        return cpInfoMapper.insertSelective(record);
    }

    @Override
    public CpInfo selectByPrimaryKey(Integer cpId) {
        return cpInfoMapper.selectByPrimaryKey(cpId);
    }

    @Override
    public int updateByPrimaryKeySelective(CpInfo record) {
        return cpInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CpInfo record) {
        return cpInfoMapper.updateByPrimaryKey(record);
    }
}
