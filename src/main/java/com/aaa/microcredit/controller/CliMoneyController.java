package com.aaa.microcredit.controller;

import com.aaa.microcredit.service.CliMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * fileName:CliMoneyController
 * description:
 * author:雷建林
 * ceeateTime:2019/8/6 20:51
 */
@Controller
@RequestMapping("climoney")
public class CliMoneyController {
    @Autowired
    private CliMoneyService service;

    @RequestMapping("query")
    @ResponseBody
    public Object query(@RequestBody Map map){
        Map mapResult=new HashMap();
        System.out.println(map.toString());
        mapResult.put("cliMoney",service.query(map));
        mapResult.put("total",service.queryPageCount(map));
        return mapResult;
    }
}
