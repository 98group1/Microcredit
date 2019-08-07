package com.aaa.microcredit.controller;

import com.aaa.microcredit.util.AverageCapitalPlusInterestUtils;
import com.aaa.microcredit.util.AverageCapitalUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/counter")
public class counterController {
    @RequestMapping("/jisuan")
    public Object jisuan(double invest,double yearRate, int totalMonth){
        //每月需要还的本金
        double perMonthPrincipal = AverageCapitalUtils.getPerMonthPrincipal(invest, totalMonth);
        System.out.println("每月需要还的本金"+perMonthPrincipal);
        //每月需要还的利息
        Map<Integer, Double> perMonthInterest = AverageCapitalUtils.getPerMonthInterest(invest, yearRate, totalMonth);
        System.out.println("每月需要还的利息"+perMonthInterest);
        //一共要还的总利息
        double interestCount = AverageCapitalUtils.getInterestCount(invest, yearRate, totalMonth);
        System.out.println("总利息"+interestCount);
        //新建一个map用来存计算出的值
        Map map=new HashMap();
        map.put("perMonthPrincipal",perMonthPrincipal);
        map.put("perMonthInterest",perMonthInterest);
        //获取perMonthInterest的长度
//        map.put("PIsize",perMonthInterest.size());
        map.put("interestCount",interestCount);
        //返回map
        return map;
    }

    @RequestMapping("/benxi")
    public Object benxi(double invest,double yearRate, int totalMonth){
        //每月要还的本金和利息之和
        double perMonthPrincipalInterest = AverageCapitalPlusInterestUtils.getPerMonthPrincipalInterest(invest, yearRate, totalMonth);
        //每月要还的利息
        Map<Integer, BigDecimal> perMonthInterest = AverageCapitalPlusInterestUtils.getPerMonthInterest(invest, yearRate, totalMonth);
        //每月要还的本金
        Map<Integer, BigDecimal> perMonthPrincipal = AverageCapitalPlusInterestUtils.getPerMonthPrincipal(invest, yearRate, totalMonth);
        //要还的总利息
        double interestCount = AverageCapitalPlusInterestUtils.getInterestCount(invest, yearRate, totalMonth);
        Map map=new HashMap();
        map.put("perMonthPrincipalInterest",perMonthPrincipalInterest);
        map.put("perMonthInterest",perMonthInterest);
        map.put("perMonthPrincipal",perMonthPrincipal);
        map.put("interestCount",interestCount);
        return map;
    }

}
