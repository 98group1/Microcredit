package com.aaa.microcredit.controller;

import com.aaa.microcredit.service.ZhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/zh")
public class ZhController {
    @Autowired
    private ZhService zhService;
    @RequestMapping("/selectkyye")
    public Object select1(@RequestParam("userId")  Integer userId){
//        Integer userId = (Integer) map.get("userId");
        Map map1 = zhService.selectAvailMoney(userId);
        System.out.println(map1);
        return map1;
    }
    @RequestMapping("/select")
    public Object select(@RequestParam("userId")  Integer userId){
        Map map1 = zhService.selectAvailMoney(userId);
        List<Map> list = zhService.selectLoan(userId);
        Map map=new HashMap();
        map.put("map1",map1);
        map.put("list",list);
        return map;
    }
}
