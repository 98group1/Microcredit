package com.aaa.microcredit.dao;

import com.aaa.microcredit.entity.CpInfo;
import com.aaa.microcredit.entity.Platform;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PlatformMapper {
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