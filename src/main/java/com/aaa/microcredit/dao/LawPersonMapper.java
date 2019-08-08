package com.aaa.microcredit.dao;

import com.aaa.microcredit.entity.LawPerson;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface LawPersonMapper {
    int deleteByPrimaryKey(Integer lawId);

    int insert(LawPerson record);

    int insertSelective(LawPerson record);

    LawPerson selectByPrimaryKey(Integer lawId);

    int updateByPrimaryKeySelective(LawPerson record);

    int updateByPrimaryKey(LawPerson record);

    /**
     * 完善法人信息方法
     * @param map
     * @return
     */
    int insertLawInfo(Map map);

    /**
     * 查询法人信息
     * @return
     */
    Map selectLawInfo(String userName);

    /**
     * 修改法人信息
     * @param map
     * @return
     */
    int updataLawInfo(Map map);
}