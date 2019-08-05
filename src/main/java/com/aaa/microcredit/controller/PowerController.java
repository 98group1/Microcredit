package com.aaa.microcredit.controller;


import com.aaa.microcredit.service.PowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @description: PowerController
 * @author: ${评生}
 * @date: 2019-07-19 19:29
 * @Version 1.0
 */
@RestController
@RequestMapping("power")
public class PowerController {
    @Autowired
    private PowerService powerService;
    /**
     * 获取权限菜单树数据
     * @return
     */
    @RequestMapping("tree")
    public Object tree(){
        return powerService.getPowerTreeData();
    }
}
