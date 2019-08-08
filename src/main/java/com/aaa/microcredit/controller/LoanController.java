package com.aaa.microcredit.controller;

import com.aaa.microcredit.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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

    /**
     * 后台取出session中的数据并返回到前台
     * @param map  前台传的需要取出来的字段
     * @param request
     * @return
     */
    @RequestMapping("/getSession")
    @ResponseBody
    public Object getSession(@RequestBody Map map,HttpServletRequest request){
        String s= (String) map.get("getSession");
        return  request.getSession().getAttribute(s);
    }

    @ResponseBody
    @RequestMapping("/selectLoan")
    public Map selectloan(@RequestBody Map map){
        Integer userId= (Integer) map.get("userId");
        System.out.println("查询贷款明细");
        List<Map> mapList = loanService.selectLoan(userId);
        Map mappage=new HashMap();
        mappage.put("mapList",mapList);
        mappage.put("total",loanService.selectLoanCount(userId));
        return mappage;
    }
}
