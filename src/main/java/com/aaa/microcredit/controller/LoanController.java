package com.aaa.microcredit.controller;

import com.aaa.microcredit.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/loan")
public class LoanController {
    @Autowired
    private LoanService loanService;
//    @ResponseBody
////    @RequestMapping("/selectLoanAll")
////    public List<Map> selectloanAll(){
////        System.out.println("查询贷款");
//////        Map map=new HashMap();
//////        map.put("loan",loanService.selectAll());
////        List<Map> mapList = loanService.selectAll();
////        return mapList;
////    }
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

    @RequestMapping("/seleLoans")
    public Object seleLoans(Integer lId){
        return loanService.selectByPrimaryKey(lId);
    }


    @RequestMapping("/page")
    @ResponseBody
    public Object selectCpAndLoan(@RequestBody Map map){
        Map resultMap=new HashMap();
        resultMap.put("selectCpAndLoan",loanService.selectCpAndLoan(map));
        resultMap.put("total",loanService.queryPageCount(map));
        return resultMap;
    }


    /**
     *
     * @param map
     * @return
     */
    @RequestMapping("/insertLoan")
    @ResponseBody
    public Object insertLoan(@RequestBody Map map){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        map.put("loan_time",df.format(new Date()));// new Date()为获取当前系统时间
        //调用修改方法修改贷款表中贷款状态
        updateStatus(map);
        Integer lid= loanService.insertLoan(map);
        Integer l_id = (Integer) map.get("l_id");
        System.out.println(map.toString()+"5555555555555");
        //调用添加明细表方法，添加明细表数据

        return insertLoanMx(map,l_id);
    }


    /**
     *
     * 放款成功之后需要添加贷款信息到贷款表中
     * @param map
     * @return
     */
    @RequestMapping("/updateLoStatus")
    @ResponseBody
    public Object updateStatus(@RequestBody Map map){
       return loanService.updateLoStatus(map);
    }



    /**
     *     放款成功根据分期数添加明细表，用于还款分期使用
     * @param map
     * @return
     */
    @RequestMapping("/insertLoanMx")
    @ResponseBody
    public Object insertLoanMx( Map map,Integer l_id){
        Map mapResult=new HashMap();
        System.out.println(map.toString());
        Object op=map.get("repaymentId");
        Object lde=map.get("loan_deadline");
        System.out.println(op);
        Integer z_periods=0;
        if((Integer)op==2){
            map.put("z_periods",lde);
             z_periods= (Integer) lde;
            System.out.println("总期数"+z_periods);
        }else {
             z_periods=1;
            System.out.println("总期数"+z_periods);
        }
        int k_per=(Integer) map.get("Loan_money")/z_periods;
        int s=0;
        for (int i = 1; i <=z_periods; i++) {
            mapResult.put("l_id",map.get("l_id"));
            mapResult.put("be_periods",i);
            mapResult.put("r_money",k_per);
            mapResult.put("ifoverdue",1);
            mapResult.put("o_accrual",0);
            mapResult.put("be_accrual",((Integer)map.get("Loan_money")/z_periods*0.012));
            mapResult.put("r_time",map.get("loan_time"));
            mapResult.put("r_status",6);
            System.out.println(mapResult);
           int b=loanService.insertMX(mapResult);
           s+=b;
        }
        if(s==z_periods){
            return 1;
        }
        return 0;
    }

    @RequestMapping("/selectLoan")
    public Object selectLoan(Integer l_id){
       return loanService.selectLoan(l_id);
    }
}
