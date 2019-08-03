package com.aaa.microcredit.dao;

import com.aaa.microcredit.entity.Loan;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface LoanMapper {
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