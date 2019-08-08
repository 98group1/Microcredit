package com.aaa.microcredit.service;

import com.aaa.microcredit.dao.PlatformMapper;
import com.aaa.microcredit.entity.Platform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: 孟浩阳
 * @Date: 2019/8/7 20:28
 */
@Service
public class PlatformServiceImpl  implements PlatformService{

    @Autowired
    private PlatformMapper platformMapper;
    @Override
    public int deleteByPrimaryKey(Integer pId) {
        return 0;
    }

    @Override
    public int insert(Platform record) {
        return 0;
    }

    @Override
    public int insertSelective(Platform record) {
        return 0;
    }

    @Override
    public Platform selectByPrimaryKey(Integer pId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Platform record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Platform record) {
        return 0;
    }

    @Override
    public int queryPageCount(Map map) {
        return platformMapper.queryPageCount(map);
    }

    @Override
    public List<Platform> queryAll(Map map) {
        return platformMapper.queryAll(map);
    }
}
