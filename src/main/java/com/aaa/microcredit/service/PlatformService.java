package com.aaa.microcredit.service;

import com.aaa.microcredit.entity.Platform;

import java.util.List;
import java.util.Map;

/**
 * @Author: 孟浩阳
 * @Date: 2019/8/7 20:27
 */
public interface PlatformService {

    int deleteByPrimaryKey(Integer pId);

    int insert(Platform record);

    int insertSelective(Platform record);

    Platform selectByPrimaryKey(Integer pId);

    int updateByPrimaryKeySelective(Platform record);

    int updateByPrimaryKey(Platform record);


    /**
     * 查询分页总数量
     * @param map
     * @return
     */
    int queryPageCount(Map map);


    /**
     * 查询所有
     * @return
     */
    List<Platform> queryAll(Map map);
}
