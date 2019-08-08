package com.aaa.microcredit.controller;

import com.aaa.microcredit.entity.Platform;
import com.aaa.microcredit.service.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: 孟浩阳
 * @Date: 2019/8/7 20:33
 */
@RestController
@RequestMapping("/platform")
//@Transactional
public class PlatformController {

    @Autowired
    private PlatformService platformService;

    @RequestMapping("/page")
    @ResponseBody
    public Object queryAll(@RequestBody Map map) {
        Map resultMap = new HashMap();
        resultMap.put("platformList", platformService.queryAll(map));
        resultMap.put("total", platformService.queryPageCount(map));
        return resultMap;
    }
}
