package com.aaa.microcredit.controller;

import com.aaa.microcredit.entity.Apply;
import com.aaa.microcredit.service.ApplyService;
import com.aaa.microcredit.util.FtpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/apply")
public class ApplyController {
    @Autowired
    private ApplyService applyService;

    @Autowired
    private FtpUtil ftpUtil;
    /**
     * 根据id查询申请信息
     * @param applyId
     * @return
     */
    @RequestMapping("selectApplyId")
    @ResponseBody
    public Apply SelectApplyId(Integer applyId){
        return applyService.selectByPrimaryKey(applyId);
    }

    /**
     * 申请资料录入
     * @param apply 参数 ，对象实体
     * @return  返回执行结果
     */
    @RequestMapping("/save")
    @ResponseBody
    public Object save(@RequestBody Apply apply){
        int result = applyService.insertSelective(apply);
        return result;
    }

    @ResponseBody
    @RequestMapping("/uploadSfzz")
    public Object uploadSfzz(@RequestParam MultipartFile bondsmanSfzz){
        System.out.println("开始上传。。。");
//        String originalFilename = bondsmanSfzz.getOriginalFilename();
        String newFileName = ftpUtil.upLoad(bondsmanSfzz);
        Map map=new HashMap();
//        map.put("originalFilename",originalFilename);
        map.put("newFileName",newFileName);
        return map;
    }

    @ResponseBody
    @RequestMapping("/uploadSfzf")
    public Object uploadSfzf(@RequestParam MultipartFile bondsmanSfzf){
        System.out.println("开始上传。。。");
//        String originalFilename = bondsmanSfzf.getOriginalFilename();
//        System.out.println(originalFilename);
        String newFileName = ftpUtil.upLoad(bondsmanSfzf);
        Map map=new HashMap();
//        map.put("originalFilename",originalFilename);
        map.put("newFileName",newFileName);
        return map;
    }

}
