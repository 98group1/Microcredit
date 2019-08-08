package com.aaa.microcredit.service;

import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface PMoneyService {
    /**
     * 查询出数据库平台流水表中数据的年限
     * @return
     */
    List<Map> selectPchangeTimeYear();
    /**
     * 查询平台可用余额
     * @return
     */
    BigDecimal selectPavailMoney();
    /**
     * 查询贷款表中状态为待还款的数据 可以根据 状态、时间（年月日）查询 ,
     * @return  返回的是查询出来的贷款钱数相加得到的总钱数
     */
    Map selectLoanMoney(Map map);

}
