package com.aaa.microcredit.controller;

import com.aaa.microcredit.dao.ClientMoneyMapper;
import com.aaa.microcredit.service.ClientMoneyService;
import com.aaa.microcredit.service.LoanService;
import javafx.beans.binding.ObjectExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/loan")
@Transactional
public class LoanController {
    @Autowired
    private LoanService loanService;
    @Autowired
    private ClientMoneyService clientMoneyService;
    @Autowired
    private ClientMoneyMapper clientMoneyMapper;
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
    @Transactional
    public Object selectCpAndLoan(@RequestBody Map map){
        Map resultMap=new HashMap();
        resultMap.put("selectCpAndLoan",loanService.selectCpAndLoan(map));
        resultMap.put("total",loanService.queryPageCount(map));

        return resultMap;
    }


    /**
     * @param map
     * @return
     */
    @RequestMapping("/insertLoan")
    @ResponseBody
    @Transactional
    public Object insertLoan(@RequestBody Map map) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        map.put("loan_time", df.format(new Date()));// new Date()为获取当前系统时间
        Map map2 = clientMoneyMapper.selectPingtai();
        BigDecimal availMoneyPingtai = (BigDecimal) map2.get("availMoney");//得到平台流水表中可用余额
        int r = availMoneyPingtai.compareTo(BigDecimal.ZERO); //和0，ZERO比较
        if (r > 0) {
            //调用修改方法修改贷款表中贷款状态
            updateStatus(map);
            Integer lid = loanService.insertLoan(map);
            Integer l_id = (Integer) map.get("l_id");
            System.out.println(map.toString() + "5555555555555");
            System.out.println(map.get("apply_id"));
            System.out.println(map.get("user_id"));
            //调用添加明细表方法，添加明细表数据
            insertLoanMx(map, l_id);
            Integer userId = (Integer) map.get("user_id");
            return clientMoneyService.selectUserId(map, userId);
        }
        System.out.println("公司账户余额不足");
        return 0;
    }


    /**
     *
     * 放款成功之后需要添加贷款信息到贷款表中
     * @param map
     * @return
     */
    @RequestMapping("/updateLoStatus")
    @ResponseBody
    @Transactional
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
    @Transactional
    public Object insertLoanMx( Map map,Integer l_id){
        Map mapResult=new HashMap();
        System.out.println(map.toString()+"9999999999999999999999999999999");
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
        Calendar calendar = new GregorianCalendar();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date =new Date();
        calendar.setTime(date);
        int s=0;
        for (int i = 1; i <=z_periods; i++) {
            System.out.println(date);
            mapResult.put("l_id",map.get("l_id"));
            mapResult.put("be_periods",i);
            mapResult.put("r_money",k_per);
            mapResult.put("ifoverdue",1);
            mapResult.put("o_accrual",0);
            mapResult.put("be_accrual",(((Integer)map.get("Loan_money")/z_periods)*0.045));
            mapResult.put("r_time",df.format(date));
            mapResult.put("r_status",6);
           int b=loanService.insertMX(mapResult);
            calendar.add(calendar.MONTH, 1);
            date=calendar.getTime();

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

@RequestMapping("/selectNews")
        public Object selectNews() {

    return   "list";
    }
}
