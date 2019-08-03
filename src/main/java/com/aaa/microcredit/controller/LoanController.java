package com.aaa.microcredit.controller;

import com.aaa.microcredit.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("loan")
public class LoanController {
    @Autowired
    private LoanService loanService;

    @ResponseBody
    @RequestMapping("/selectLoanMxAll")
    public Map selectloanMxAll(@RequestBody Map map){
        System.out.println("查询贷款明细");
        System.out.println(map.get("start"));
        List<Map> mapList = loanService.selectMxPjAll(map);
        Map mappage=new HashMap();
        mappage.put("mapList",mapList);
        mappage.put("total",loanService.selectAllCount(map));
        return mappage;
    }
}
