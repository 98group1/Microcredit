package com.aaa.microcredit.service;

import com.aaa.microcredit.entity.Loan;

import java.util.List;
import java.util.Map;

public interface LoanService {
    int deleteByPrimaryKey(Integer lId);

    int insert(Loan record);

    int insertSelective(Loan record);

    Loan selectByPrimaryKey(Integer lId);

    int updateByPrimaryKeySelective(Loan record);

    int updateByPrimaryKey(Loan record);

    /**
     * 查询贷款信息
     * @return
     */
    List<Map> selectAll(Map map);
    /**
     * 联合明细表查询
     * @return
     */
    List<Map> selectMxAll();
    /**
     * 查询贷款条数
     * @return
     */
    Integer selectAllCount(Map map);
    /**
     * 用Map拼接还款表和明细表
     * @return
     */
    List<Map> selectMxPjAll(Map map);
    /**
     * 根据前台用户id查询贷款信息
     * @param userId
     * @return
     */
    List<Map> selectLoan(Integer userId);
    /**
     * 查询贷款条数
     * @return
     */
    Integer selectLoanCount(Integer userId);
}
