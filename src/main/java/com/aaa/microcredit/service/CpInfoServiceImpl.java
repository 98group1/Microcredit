package com.aaa.microcredit.service;

import com.aaa.microcredit.dao.CpInfoMapper;
import com.aaa.microcredit.entity.CpInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    @Override
    public int queryPageCount(Map map) {
        return cpInfoMapper.queryPageCount(map);
    }

    @Override
    public List<CpInfo> queryAll(Map map) {
        return cpInfoMapper.queryAll(map);
    }


    @Override
    public List queryAllTest() {
        return cpInfoMapper.queryAllTest();
    }

    @Override
    public List queryStatus1(Map map) {
        return cpInfoMapper.queryStatus1(map);
    }

    @Override
    public Integer updateStatus(Map map) {
        return cpInfoMapper.updateStatus(map);
    }

    @Override
    public int insertInfo(Map map) {
        return cpInfoMapper.insertInfo(map);
    }


}
