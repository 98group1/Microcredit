package com.aaa.microcredit.controller;

import com.aaa.microcredit.util.FtpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/uploadZj")
public class UploadZjController {
    @Autowired
    private FtpUtil ftpUtil;
    @RequestMapping("/ndbb")
    public Object uploadSfzz(@RequestParam MultipartFile ndbb){
        System.out.println("开始上传。。。");
        String originalFilename = ndbb.getOriginalFilename();
        String newFileName = ftpUtil.upLoad(ndbb);
        System.out.println(newFileName);
        Map map=new HashMap();
        map.put("originalFilename",originalFilename);
        map.put("newFileName",newFileName);
        System.out.println(map);
        return map;
    }
}
