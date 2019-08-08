package com.aaa.microcredit.controller;

import com.aaa.microcredit.service.LawPersonService;
import com.aaa.microcredit.util.FtpConfig;
import com.aaa.microcredit.util.FtpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * fileName:LawPersonController
 * description:
 * author:雷建林
 * ceeateTime:2019/8/7 15:03
 */
@RestController
@RequestMapping("lawperson")
public class LawPersonController {
    @Autowired
    private LawPersonService service;

    @Autowired
    private FtpUtil ftpUtil;  //ftp工具类

    @Autowired
    private ResourceLoader resourceLoader; //显示图片使用，加载资源的类

    @Autowired
    private FtpConfig ftpConfig; //显示图片时，要拼接下载路径时用到配置文件的配置

    /**
     * 完善法人信息
     * @param map
     * @return
     */
    @RequestMapping("lawInfo1")
    public Object LawInfo1(@RequestBody Map map){
        return service.insertLawInfo(map);
    }

    /**
     * 查询法人信息并显示到页面
     * @param request
     * @return
     */
    @RequestMapping("selectLawInfo")
    public Object selectLawInfo(HttpServletRequest request){
        Map login1 = (Map) request.getSession().getAttribute("login1");
        String userName = (String) login1.get("username");
        return service.selectLawInfo(userName);
    }

    /**
     * 更改法人信息
     * @param map
     * @return
     */
    @RequestMapping("updateLawInfo")
    public Object updateLawInfo(@RequestBody Map map){
        return service.updataLawInfo(map);
    }

    /*
     *
     * 身份证反面上传
     * @param
     * @return
     */
    @RequestMapping("/uploadlawSfzf")
    public Object uploadlawSfzf(@RequestParam MultipartFile lawSfzf){
        String originalFilename=lawSfzf.getOriginalFilename();
        String newFileName=ftpUtil.upLoad(lawSfzf);
        Map map=new HashMap();
        map.put("originalFilename",originalFilename);
        map.put("newFileName",newFileName);
        return map;
    }

    /*
     *
     * 身份证正面上传
     * @param
     * @return
     */
    @RequestMapping("/uploadlawSfzz")
    public Object uploadlawSfzz(@RequestParam MultipartFile lawSfzz){
        String originalFilename=lawSfzz.getOriginalFilename();
        String newFileName=ftpUtil.upLoad(lawSfzz);
        Map map=new HashMap();
        map.put("originalFilename",originalFilename);
        map.put("newFileName",newFileName);
        return map;
    }

    @RequestMapping("/show")
    public ResponseEntity show(String fileName){
        //获取格式：//ftp://admin:admin@192.168.11.116/图片上传目录/文件名
        return ResponseEntity.ok(resourceLoader.getResource("ftp://"+ftpConfig.getFtpUserName()+":"+
                ftpConfig.getFtpPassWord()+"@"+ftpConfig.getRemoteIp()+ftpConfig.getRemotePath()+"/"+fileName));
    }
}
