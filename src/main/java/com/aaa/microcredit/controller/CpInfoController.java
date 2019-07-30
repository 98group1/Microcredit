package com.aaa.microcredit.controller;

import com.aaa.microcredit.entity.CpInfo;

import com.aaa.microcredit.service.CpInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cpInfo")
public class CpInfoController {
    @Autowired
    private CpInfoService cpInfoService;

    @RequestMapping("/selectCpInfoId")
    @ResponseBody
    public CpInfo selectCpInfoId(Integer cpId) {
        return cpInfoService.selectByPrimaryKey(cpId);
    }

    /**
     * 分页查询
     *
     * @param map
     * @return
     */
    @RequestMapping("/page")
    @ResponseBody
    public Object queryAll(@RequestBody Map map) {
        System.out.println("..+++........+++++++++.");
        Map resultMap = new HashMap();
        resultMap.put("cpInfoList", cpInfoService.queryAll(map));
        resultMap.put("total", cpInfoService.queryPageCount(map));
        System.out.println("OKOKOKOKOKOKOK");
        return resultMap;
    }

    /**
     * 保存
     * @param CpInfo
     * @return
     */
    @RequestMapping("/save")
    public Object save(@RequestBody CpInfo CpInfo){
        return cpInfoService.insertSelective(CpInfo);
    }

    /**
     * 修改
     * @param CpInfo
     * @return
     */
    @RequestMapping("/update")
    public Object update(@RequestBody CpInfo CpInfo){
        return cpInfoService.updateByPrimaryKeySelective(CpInfo);
    }
    /**
     * 删除
     * @param CpId
     * @return
     */
    @RequestMapping("/delete")
    public Object delete(Integer CpId){
        return cpInfoService.deleteByPrimaryKey(CpId);
    }






}
