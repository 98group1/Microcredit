package com.aaa.microcredit.controller;

import com.aaa.microcredit.entity.Apply;
import com.aaa.microcredit.entity.Photo;
import com.aaa.microcredit.service.PhotoService;
import com.aaa.microcredit.util.FtpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
    private PhotoService photoService;

    @Autowired
    private FtpUtil ftpUtil;

    /**
     * 上传年度报表
     * @param ndbb
     * @return
     */
    @RequestMapping("/ndbb")
    public Object uploadNdbb(@RequestParam MultipartFile ndbb){
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

    /**
     * 上传公司章程
     * @param gszc
     * @return
     */
    @RequestMapping("/gszc")
    public Object uploadGszc(@RequestParam MultipartFile gszc){
        System.out.println("开始上传公司章程");
        String originalFilename = gszc.getOriginalFilename();
        String newFileName = ftpUtil.upLoad(gszc);
        Map map=new HashMap();
        map.put("originalFilename",originalFilename);
        map.put("newFileName",newFileName);
        return map;
    }

    /**
     * 上传经营场地合同
     * @param jycdht
     * @return
     */
    @RequestMapping("/jycdht")
    public Object uploadJycdht(@RequestParam MultipartFile jycdht){
        System.out.println("开始上传经营场地合同");
        String originalFilename = jycdht.getOriginalFilename();
        String newFileName = ftpUtil.upLoad(jycdht);
        Map map=new HashMap();
        map.put("originalFilename",originalFilename);
        map.put("newFileName",newFileName);
        return map;
    }

    /**
     * 上传开户许可证
     * @param khxk
     * @return
     */
    @RequestMapping("/khxk")
    public Object uploadKhxk(@RequestParam MultipartFile khxk){
        System.out.println("开始上传开户许可证");
        String originalFilename = khxk.getOriginalFilename();
        String newFileName = ftpUtil.upLoad(khxk);
        Map map=new HashMap();
        map.put("originalFilename",originalFilename);
        map.put("newFileName",newFileName);
        return map;
    }

    /**
     * 上传税务登记证
     * @param swdj
     * @return
     */
    @RequestMapping("/swdj")
    public Object uploadSwdj(@RequestParam MultipartFile swdj){
        System.out.println("开始上传税务登记证");
        String originalFilename = swdj.getOriginalFilename();
        String newFileName = ftpUtil.upLoad(swdj);
        Map map=new HashMap();
        map.put("originalFilename",originalFilename);
        map.put("newFileName",newFileName);
        return map;
    }

    /**
     * 上传验资报告
     * @param yzbj
     * @return
     */
    @RequestMapping("/yzbj")
    public Object uploadYzbj(@RequestParam MultipartFile yzbj){
        System.out.println("开始上传验资报告");
        String originalFilename = yzbj.getOriginalFilename();
        String newFileName = ftpUtil.upLoad(yzbj);
        Map map=new HashMap();
        map.put("originalFilename",originalFilename);
        map.put("newFileName",newFileName);
        return map;
    }

    /**
     * 上传组织机构代码证
     * @param zzjgdm
     * @return
     */
    @RequestMapping("/zzjgdm")
    public Object uploadZzjgdm(@RequestParam MultipartFile zzjgdm){
        System.out.println("开始上传组织机构代码证");
        String originalFilename = zzjgdm.getOriginalFilename();
        String newFileName = ftpUtil.upLoad(zzjgdm);
        Map map=new HashMap();
        map.put("originalFilename",originalFilename);
        map.put("newFileName",newFileName);
        return map;
    }


    /**
     * 录入
     * @param photo
     * @return
     */
    @RequestMapping("/save")
    public Object save(@RequestBody Photo photo){
        int result = photoService.insertSelective(photo);
        return result;
    }

    /**
     * 根据申请id查询
     * @param apply 传的参数为实体
     * @return
     */
    @RequestMapping("/selectByApplyId")
    public Object selecByApplyId(@RequestBody Apply apply){
        Integer applyId = apply.getApplyId();
        System.out.println("id为："+applyId);
        Photo photo = photoService.selectByApply(applyId);
        Map map=new HashMap();
        map.put("photo",photo);
        return map;
    }




}
