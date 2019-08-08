package com.aaa.microcredit.service;

import java.util.List;
import java.util.Map;

public interface ZhService {
    /**
     * 查询出某客户最新的可用余额
     * @return
     */
    Map selectAvailMoney(Integer userId);

    /**
     * 查询该用户的贷款的信息，将对应的值显示在账户上
     * @param userId //参数
     * @return
     */
    List<Map> selectLoan(Integer userId);


}
