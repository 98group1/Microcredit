package com.aaa.microcredit.service;



import java.util.Map;

public interface HkService {
    /**
     * 点击还款修改明细表里的贷款状态,
     * 当该贷款单所有期数都还完得时候修改贷款表里得贷款状态
     */
    Integer hkcz(Map map);

    /**
     * 查询出某客户最新的可用余额
     * @return
     */
    Map selectAvailMoney(Integer userId);
    /**
     * 向流水表里录入数据  充值
     * @param map
     * @return
     */
    Integer insertMoney(Map map);
    /**
     * 查询平台流水表里最新的可用余额
     * @return
     */
    Map selectPTAvailMoney();
}
