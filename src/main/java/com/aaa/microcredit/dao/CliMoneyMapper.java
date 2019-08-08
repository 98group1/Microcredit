package com.aaa.microcredit.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * fileName:CliMoneyMapper
 * description:
 * author:雷建林
 * ceeateTime:2019/8/6 20:41
 */
@Repository
public interface CliMoneyMapper {
    /**
     * 查询客户账户表中的信息
     * @param map
     * @return
     */
    //@Select("select c_changemoney,c_changetime,c_availmoney from client_money where user_id=#{userId} " +
      //      "order by c_changetime desc limit start1=#{start} and end=#{end}")
    List<Map> query(Map map);

    /**
     * 查询该用户账户表中共有多少条资金记录
     * @param map
     * @return
     */
    //@Select("select count(*) from client_money where user_id=#{userId}")
    int queryPageCount(Map map);
}
