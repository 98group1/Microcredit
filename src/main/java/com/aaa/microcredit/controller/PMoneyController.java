package com.aaa.microcredit.controller;

import com.aaa.microcredit.service.PMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @RequestMapping("selectPchangeTimeYear")
    public List<Map> selectPchangeTimeYear(){
        return pMoneyService.selectPchangeTimeYear();
    }
    @RequestMapping("selectPavailMoney")
    public BigDecimal selectPavailMoney(){
        return pMoneyService.selectPavailMoney();
    }
}
