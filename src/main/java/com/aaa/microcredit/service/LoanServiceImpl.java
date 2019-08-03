package com.aaa.microcredit.service;

import com.aaa.microcredit.dao.LoanMapper;
import com.aaa.microcredit.entity.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @Author: 孟浩阳
 * @Date: 2019/8/1 21:04
 */
@Service
public class LoanServiceImpl  implements LoanService{
    @Autowired
    private LoanMapper loanMapper;
    @Override
    public int deleteByPrimaryKey(Integer lId) {
        return loanMapper.deleteByPrimaryKey(lId) ;
    }

    @Override
    public int insert(Loan record) {
        return loanMapper.insert(record);
    }

    @Override
    public int insertSelective(Loan record) {
        return loanMapper.insertSelective(record);
    }

    @Override
    public Loan selectByPrimaryKey(Integer lId) {
        return loanMapper.selectByPrimaryKey(lId);
    }

    @Override
    public int updateByPrimaryKeySelective(Loan record) {
        return updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Loan record) {
        return updateByPrimaryKeySelective(record);
    }

    @Override
    public List<Map> selectCpAndLoan(Map map) {
        return loanMapper.selectCpAndLoan(map);
    }

    @Override
    public int queryPageCount(Map map) {
        return loanMapper.queryPageCount(map);
    }

    @Override
    public int insertLoan(Map map) {

        return loanMapper.insertLoan(map);
    }
}
