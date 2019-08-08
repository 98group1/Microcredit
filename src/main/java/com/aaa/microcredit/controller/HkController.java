package com.aaa.microcredit.controller;

import com.aaa.microcredit.service.HkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/hk")
public class HkController {
    @Autowired
    private HkService hkService;
    @RequestMapping("/updateStatus")
    public Object updateStatus(@RequestBody Map map){
        //获取系统当前时间
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=new Date();
        map.put("c_changetime",dateFormat.format(date));
        System.out.println(map.get("c_changetime"));
        return hkService.hkcz(map);
    }

    /**
     * 查询某用户的最新可用余额
     * @return
     */
    @RequestMapping("/selectAvailMoney")
    public Object selectAvailMoney(@RequestBody Map map){
        Integer userId= (Integer) map.get("userId");
        Map map1 = hkService.selectAvailMoney(userId);
        System.out.println(map1);
        return  map1;
    }

    /**
     * 向流水表里录入资金变动的数据
     * @param map
     * @return
     */
    @RequestMapping("/insertMoney")
    public Object insertMoney(@RequestBody Map map){
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=new Date();
        map.put("c_changetime",dateFormat.format(date));
        return hkService.insertMoney(map);
    }
}


