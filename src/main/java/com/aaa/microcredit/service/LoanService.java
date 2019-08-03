package com.aaa.microcredit.service;

import com.aaa.microcredit.entity.Loan;

import java.util.List;
import java.util.Map;

/**
 * @Author: 孟浩阳
 * @Date: 2019/8/1 21:04
 */
public interface LoanService {
    int deleteByPrimaryKey(Integer lId);

    int insert(Loan record);

    int insertSelective(Loan record);

    Loan selectByPrimaryKey(Integer lId);

    int updateByPrimaryKeySelective(Loan record);

    int updateByPrimaryKey(Loan record);

    /**
     *     查询cp_info loan dictionary表
     * @param map
     * @return
     */
    List<Map> selectCpAndLoan(Map map);
    /**
     * 查询分页总数量
     * @param map
     * @return
     */
    int queryPageCount(Map map);

    /**
     * 放款添加表数据
     * @param map
     * @return
     */
    int insertLoan(Map map);
}
