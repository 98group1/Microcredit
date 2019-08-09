package com.aaa.microcredit.service;

import com.aaa.microcredit.dao.PMoneyMapper;
import com.aaa.microcredit.entity.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class PMoneyServiceImpl implements PMoneyService {
    @Autowired
    private PMoneyMapper pMoneyMapper;

    /**
     * 查询流水表中数据的年限
     * @return  返回的是年限数组
     */
    @Override
    public List<Map> selectPchangeTimeYear() {
        return pMoneyMapper.selectPchangeTimeYear();
    }

    /**
     * 查询平台的可用余额
     * @return 返回的是平台的余额
     */
    @Override
    public BigDecimal selectPavailMoney() {
        return pMoneyMapper.selectPavailMoney();
    }

    /**
     * 查询贷款表中状态为待还款的数据 可以根据 状态、时间（年月日）查询 ,
     * @return  返回的是查询出来的贷款钱数相加得到的总钱数 贷款金额 已还金额 已还利息
     */
    @Override
    public Map selectLoanMoney(Map map) {
        System.out.println(map.toString());
        //查询数据库中贷款表的信息
        List<Map> list = pMoneyMapper.selectLoanMoney( map);
        //创建新的map用来存放信息
        Map selectMap=new HashMap();
        //定义一个新的BigDecimal变量用来存放贷款总额
        BigDecimal ZongloanMoney=BigDecimal.ZERO;
        BigDecimal ZongRMoney=BigDecimal.ZERO;
        for (Map loan : list) {
            //从读出来的数据中取出每一条数据中的贷款金额
            BigDecimal loanMoney= (BigDecimal) loan.get("loan_money");
            //相加得到总金额
            ZongloanMoney=ZongloanMoney.add(loanMoney);
            System.out.println(ZongloanMoney);
            //已还金额
            BigDecimal rMoney= (BigDecimal) loan.get("r_money");
            ZongRMoney=rMoney.add(ZongRMoney);
            System.out.println(ZongRMoney);
        }
        selectMap.put("dkje",ZongloanMoney);
        System.out.println(selectMap.toString());
        System.out.println("开始计算利息");
        map.put("status",7);
        System.out.println(map.toString());
        //查询数据库中贷款表的信息
        BigDecimal LoanLxMoney=BigDecimal.ZERO;
        BigDecimal LoanBjMoney=BigDecimal.ZERO;
        List<Map> listMx = pMoneyMapper.selectLoanLxMoney(map);
        for (Map mx : listMx) {
            //获取已还的利息
            BigDecimal lx= (BigDecimal) mx.get("be_accrual");//每期还款利息
            LoanLxMoney= LoanLxMoney.add(lx);
            BigDecimal bj= (BigDecimal) mx.get("r_money"); //每期还款本金
            LoanBjMoney=LoanBjMoney.add(bj);
        }
        selectMap.put("yhbj",LoanBjMoney);
        selectMap.put("yhlx",LoanLxMoney);
        System.out.println(selectMap.toString());
        return selectMap;
    }

}
