package com.aaa.microcredit.dao;

import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @Author: 孟浩阳
 * @Date: 2019/8/6 19:35
 */
@Repository
public interface ClientMoneyMapper {
    /**
     * 通过用户id查询流水表中用户的最新记录
     * @return
     */
   Map selectUserId(Integer UserId);

    /**
     * 像流水表中添加一条数据
     * @return
     */
    Integer insert(Map map);

    /**
     * 通过用户id查询流水表中用户的最新记录
     * @return
     */
    Map selectPingtai();

    /**
     * 像流水表中添加一条数据
     * @return
     */
    Integer insertPingtai(Map map);

    /**
     * 贷款同时往news表添加一条数据，用于通知用户
     * @param map
     * @return
     */
    Integer insertNews(Map map);

    /**
     * 查询news表中最新的一条数据
     * @return
     */

    Map selectApply();
}
