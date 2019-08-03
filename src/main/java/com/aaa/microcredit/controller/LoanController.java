package com.aaa.microcredit.controller;

import com.aaa.microcredit.entity.Loan;
import com.aaa.microcredit.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author: 孟浩阳
 * @Date: 2019/8/1 21:08
 */
@RestController
@RequestMapping("/loan")
public class LoanController {
    @Autowired
    private LoanService loanService;

    @RequestMapping("/seleLoans")
    public Object seleLoans(Integer lId){
       return loanService.selectByPrimaryKey(lId);
    }


    @RequestMapping("/page")
    @ResponseBody
    public Object selectCpAndLoan(@RequestBody Map map){
        System.out.println("+++++++++++++++++++++++++++++++++++++++"+map);
        Map resultMap=new HashMap();
        resultMap.put("selectCpAndLoan",loanService.selectCpAndLoan(map));
        resultMap.put("total",loanService.queryPageCount(map));
        System.out.println("++++++++*************************************"+resultMap);
            return resultMap;
    }




    @RequestMapping("/insertLoan")
    @ResponseBody
    public Object insertLoan(@RequestBody Map map){
       /* SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
       map.put("loan_time",df);*/
        int lId = loanService.insertLoan(map);
        System.out.println(lId);
        return lId;
    }
}
