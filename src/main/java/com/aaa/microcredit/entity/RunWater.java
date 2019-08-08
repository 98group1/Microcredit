package com.aaa.microcredit.entity;

import lombok.Data;

/**
 * @Author: 孟浩阳
 * @Date: 2019/8/6 14:45
 */
@Data
public class RunWater {

    Integer C_id; //客户流水id；
    Integer user_id; //用户id
    Integer c_Moneytype;//资金变动类型
    double c_changemoney;//变动资金
    String c_changetime;//变动时间
    double c_availmoney;//可用资金
    String c_describes;//描述

    Integer P_id;//主键id；
    Integer loanid;//贷款编号
    Integer Moneytype; //资金变动类型  0 借款   1  还款
    double changemoney;//变动金额
    String Change_time;//变动时间
    double availmoney;//可用资金
    String describes;//描述

}
