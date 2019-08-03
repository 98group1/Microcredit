package com.aaa.microcredit.controller;

import com.aaa.microcredit.entity.Apply;
import com.aaa.microcredit.service.ApplyService;
import com.aaa.microcredit.util.FtpConfig;
import com.aaa.microcredit.util.FtpUtil;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/apply")
public class ApplyController {
    @Autowired
    private ApplyService applyService;

    @Autowired
    private FtpUtil ftpUtil;

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private FtpConfig ftpConfig;
    /**
     * 根据申请id查询申请信息
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
    public Object save(@RequestBody Apply apply){
        int result = applyService.insertSelective(apply);
        System.out.println(result);
        return result;
    }

    /**
     * 根据用户id查询申请信息
     * @param map
     * @return
     */
    @RequestMapping("/selectByUserId")
    //参数用map接收
    public Object selectByUserId(@RequestBody Map map){
        //获取用户id
        Integer userId= (Integer) map.get("userId");
        List<Map> applyList = applyService.selectByUserId(userId);
        return applyList;
    }

    /**
     * 根据申请id查询对应的申请信息
     * @param
     * @return
     */
    @RequestMapping("/selectById")
    public Object selectById(@RequestBody Apply apply1){
        int applyId=apply1.getApplyId();
        Map map = applyService.selectByApplyId(applyId);
        return map;

    }



    /**
     * 上传身份证正面
     * @param bondsmanSfzz
     * @return
     */
    @ResponseBody
    @RequestMapping("/uploadSfzz")
    public Object uploadSfzz(@RequestParam MultipartFile bondsmanSfzz){
        System.out.println("开始上传。。。");
        String newFileName = ftpUtil.upLoad(bondsmanSfzz);
        Map map=new HashMap();
        map.put("newFileName",newFileName);
        return map;
    }

    @ResponseBody
    @RequestMapping("/uploadSfzf")
    public Object uploadSfzf(@RequestParam MultipartFile bondsmanSfzf){
        System.out.println("开始上传。。。");
        String newFileName = ftpUtil.upLoad(bondsmanSfzf);
        Map map=new HashMap();
        map.put("newFileName",newFileName);
        return map;
    }

    /**
     * 显示头像
     * @param fileName
     * @return
     */
    @RequestMapping("/show")
    public ResponseEntity show(String fileName, HttpServletRequest request){
        //ftp://admin:admin@192.168.11.116/ftp-dir-xn/84c7f5ed-17e1-4f9a-a775-552254d66386.jpg
        String FtpUserName=ftpConfig.getFtpUserName();
        String FtpPassWord=ftpConfig.getFtpPassWord();
        String RemoteIp=ftpConfig.getRemoteIp();
        String RemotePath=ftpConfig.getRemotePath();
        Map map=new HashMap();
        map.put("FtpUserName",FtpUserName);
        map.put("FtpPassWord",FtpPassWord);
        map.put("RemoteIp",RemoteIp);
        map.put("RemotePath",RemotePath);
        request.getSession().setAttribute("ftpUrl",map);
        System.out.println("ftp://"+ftpConfig.getFtpUserName()+":"+
                ftpConfig.getFtpPassWord()+"@"+ftpConfig.getRemoteIp()+ftpConfig.getRemotePath()+"/"+fileName);
        return ResponseEntity.ok(resourceLoader.getResource("ftp://"+ftpConfig.getFtpUserName()+":"+
                ftpConfig.getFtpPassWord()+"@"+ftpConfig.getRemoteIp()+ftpConfig.getRemotePath()+"/"+fileName));
    }

    @ResponseBody
    @RequestMapping("selectApplyAll")
    public Map selectApplyAll(){
        return applyService.selectApplyAll();
    }
}
