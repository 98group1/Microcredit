package com.aaa.microcredit.service;

import java.util.Map;

/**
 * @Author: 孟浩阳
 * @Date: 2019/8/6 19:43
 */
public interface ClientMoneyService {
    /**
     * 通过用户id查询流水表中用户的最新记录,并将新的数据录入
     * @return
     */
    Integer selectUserId(Map map, Integer UserId);


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
