package com.aaa.microcredit.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
@Repository
public interface PMoneyMapper {
    /**
     * 查询平台可用余额
     * @return
     */
   @Select("select availmoney from platform_money where P_id=(SELECT Max(p_id) from platform_money ) ")
    BigDecimal selectPavailMoney();

    /**
     * 查询贷款表中状态为待还款的数据 可以根据 状态、时间（年月日）查询
     * @return
     */
    @Select("<script>SELECT *  from loan <where> " +
            "<if test=\"status!=null and status!=''\"> status=#{status} </if> " +
            "<if test=\"year!='' and year!=null\"> and DATE_FORMAT(loan_time,'%Y')=#{year} </if>" +
            "<if test=\"month!='' and month!=null\"> and DATE_FORMAT(loan_time,'%m')=#{month} </if>" +
            "<if test=\"day!='' and day!=null\"> and DATE_FORMAT(loan_time,'%d')=#{day} </if>" +
            "</where></script>")
    List<Map> selectLoanMoney(Map map);

    /**
     * 查询出数据库平台流水表中数据的年限
     * @return
     */
    @Select("SELECT DATE_FORMAT(change_time,'%Y') year from platform_money GROUP BY DATE_FORMAT(change_time,'%Y')")
    List<Map> selectPchangeTimeYear();

    /**
     * 查询贷款明细表中状态为已还款的数据 可以根据 状态、时间（年月日）查询 用于计算已还的利息
     * @return
     */
    @Select("<script> SELECT *  from loan_mx <where> " +
            "<if test=\"status!=null and status!=''\"> status=#{status} </if> " +
            "<if test=\"year!='' and year!=null\"> and DATE_FORMAT(r_time,'%Y')=#{year} </if>" +
            "<if test=\"month!='' and month!=null\"> and DATE_FORMAT(r_time,'%m')=#{month} </if>" +
            "<if test=\"day!='' and day!=null\"> and DATE_FORMAT(r_time,'%d')=#{day} </if>" +
            "</where></script>")
    List<Map> selectLoanLxMoney(Map map);
}
