package com.aaa.microcredit.controller;

import com.aaa.microcredit.entity.CpInfo;

import com.aaa.microcredit.entity.Login;
import com.aaa.microcredit.service.CpInfoService;
import com.aaa.microcredit.util.FtpConfig;
import com.aaa.microcredit.util.FtpUtil;
import com.aaa.microcredit.util.PhoneCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/cpInfo")
@Transactional
public class CpInfoController {
    @Autowired
    private CpInfoService cpInfoService;

    @Autowired
    private FtpUtil ftpUtil;  //ftp工具类

    @Autowired
    private ResourceLoader resourceLoader; //显示图片使用，加载资源的类

    @Autowired
    private FtpConfig ftpConfig; //显示图片时，要拼接下载路径时用到配置文件的配置


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

        Map resultMap = new HashMap();
        resultMap.put("cpInfoList", cpInfoService.queryAll(map));
        resultMap.put("total", cpInfoService.queryPageCount(map));
        System.out.println("执行分页查询");
        return resultMap;
    }

    /**
     *
     * 查询一审
     * @param map
     * @return
     */
    @RequestMapping("/querystatus1")
    @ResponseBody
    public Object queryStatus1(@RequestBody Map map){
        System.out.println(map.get("status"));
        System.out.println(map.get("start"));
        System.out.println(map.get("pageSize")+",,,,,,,,,,,,,,,,,,");
        Map map1=new HashMap();
       map1.put("querystatus1",cpInfoService.queryStatus1(map));
       //查询一审
       return map1;
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
     * 修该为黑名单用户
     * @param map
     * @return
     */
    @RequestMapping("/updateStatus")
    public Object update(@RequestBody Map map){
        System.out.println(map);
        return cpInfoService.updateStatus(map);
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

/*
     *
     * 文件上传
     * @param
     * @return
*/
    @RequestMapping("/uploadHeadPic")
    public Object uploadPic(@RequestParam MultipartFile  headPic){
        String originalFilename=headPic.getOriginalFilename();
        String newFileName=ftpUtil.upLoad(headPic);
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

    @RequestMapping("/downLoad")

    public void downLoad(String fileName, String originalName, HttpServletResponse response){
        //调用封装方法
        ftpUtil.downLoad(fileName,response);
    }


    /**
     * 获取手机验证码,放在session中
     */
    @RequestMapping("phone")
     public void getPhone(String tel, HttpServletRequest request){
        String s = PhoneCodeUtil.phoneCode(tel);
        request.getSession().setAttribute("s",s);
    }

    /**
     * 把session中的验证码和页面传过来的做对比
     * @param request
     * @param passWord1
     * @return
     */
    @RequestMapping("tocompare")
    public Object comparePassWord(HttpServletRequest request,String passWord1){
        String s = (String) request.getSession().getAttribute("s");
        if (passWord1.equals(s)){
            return "true";
        }
        return "false";
    }

    /*
     *
     * 营业执照图片上传
     * @param
     * @return
     */
    @RequestMapping("/uploadYyzz")
    public Object uploadYyzz(@RequestParam MultipartFile  yyzz){
        String originalFilename=yyzz.getOriginalFilename();
        String newFileName=ftpUtil.upLoad(yyzz);
        Map map=new HashMap();
        map.put("originalFilename",originalFilename);
        map.put("newFileName",newFileName);
        return map;
    }

    /*
     *
     * 营业执照图片上传
     * @param
     * @return
     */
    @RequestMapping("/uploadghtx")
    public Object uploadghtx(@RequestParam MultipartFile  ghtx){
        String originalFilename=ghtx.getOriginalFilename();
        String newFileName=ftpUtil.upLoad(ghtx);
        Map map=new HashMap();
        map.put("originalFilename",originalFilename);
        map.put("newFileName",newFileName);
        return map;
    }

    /**
     * 完善公司信息
     * @param map
     * @return
     */
    @RequestMapping("cpInfo1")
    public Object cpInfo1(@RequestBody Map map){
        int i = cpInfoService.insertInfo(map);
        return i;
    }

    /**
     * 更换头像
     * @param map
     * @param request
     * @return
     */
    @RequestMapping("changeHead")
    public Object changeHead(@RequestBody Map map,HttpServletRequest request){
        Map login1 = (Map) request.getSession().getAttribute("login1");
        String userName = (String) login1.get("username");
        int i = cpInfoService.changeHead(userName, (String) map.get("headPortrait"));
        return i;
    }

    /**
     * 查询公司信息并显示到页面
     * @param request
     * @return
     */
    @RequestMapping("selectCpInfo")
    public Object selectCpInfo(HttpServletRequest request){
        Map login1 = (Map) request.getSession().getAttribute("login1");
        String userName = (String) login1.get("username");
        Map map = cpInfoService.selectCpInfo(userName);
        return map;
    }

    /**
     * 查询头像并显示到页面
     * @param request
     * @return
     */
    @RequestMapping("selectHead")
    public Object selectHead(HttpServletRequest request){
        Map login1 = (Map) request.getSession().getAttribute("login1");
        String userName = (String) login1.get("username");
        Map map = cpInfoService.selectHead(userName);
        return map;
    }

    @RequestMapping("updateCpInfo")
    public Object updateCpInfo(@RequestBody Map map){
        int i = cpInfoService.updataCpInfo(map);
        return i;
    }
}
