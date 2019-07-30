package com.aaa.microcredit.dao;

import com.aaa.microcredit.entity.CpInfo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CpInfoMapper {
    int deleteByPrimaryKey(Integer cpId);

    int insert(CpInfo record);

    int insertSelective(CpInfo record);

    CpInfo selectByPrimaryKey(Integer cpId);

    int updateByPrimaryKeySelective(CpInfo record);

    int updateByPrimaryKey(CpInfo record);

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
    List<CpInfo> queryAll(Map map);


    List queryAllTest();
}