package com.aaa.microcredit.controller;

import com.aaa.microcredit.entity.CpInfo;
import com.aaa.microcredit.service.CpInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/cpInfo")
public class CpInfoController {
    @Autowired
    private CpInfoService cpInfoService;

    @RequestMapping("/selectCpInfoId")
    @ResponseBody
    public CpInfo selectCpInfoId(Integer cpId){
        return cpInfoService.selectByPrimaryKey(cpId);
    }

}
