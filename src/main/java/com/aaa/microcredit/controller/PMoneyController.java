package com.aaa.microcredit.controller;

import com.aaa.microcredit.service.PMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("pMoney")
public class PMoneyController {
    @Autowired
    private PMoneyService pMoneyService;

    /**
     * 查询流水表中的年限
     * @return
     */
    @RequestMapping("selectPchangeTimeYear")
    public List<Map> selectPchangeTimeYear(){
        return pMoneyService.selectPchangeTimeYear();
    }
    /**
     * 查询平台可用余额
     * @return
     */
    @RequestMapping("selectPavailMoney")
    public BigDecimal selectPavailMoney(){
        return pMoneyService.selectPavailMoney();
    }

    /**
     * 查询 贷款金额 已还金额 已还利息
     * @param map
     * @return
     */
    @RequestMapping("selectLoanMoney")
    public Map selectLoanMoney(@RequestBody Map map){
        return pMoneyService.selectLoanMoney(map);
    }
}
