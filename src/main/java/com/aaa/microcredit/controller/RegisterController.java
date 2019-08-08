package com.aaa.microcredit.controller;

import com.aaa.microcredit.entity.Login;
import com.aaa.microcredit.service.RegisterService;
import org.apache.ibatis.annotations.Insert;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * fileName:RegisterController
 * description:
 * author:雷建林
 * ceeateTime:2019/7/27 16:18
 */
@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private RegisterService service;
    private String hashAlgorithmName="MD5";
    private Integer  hashIterations=1024;

    /**
     * 注册方法
     * @param login
     * @return
     */
    @RequestMapping("/reg1")
    public Object register(Login login){
        //原始密码
        String source= login.getPassWord();
        //盐
        ByteSource credentialsSalt= ByteSource.Util.bytes(login.getUserName());
        String credentials= new SimpleHash(hashAlgorithmName, source, credentialsSalt,hashIterations ).toHex();
        //设置加密后的密码
        login.setPassWord(credentials);
        int i = service.addUser(login);
        return i;
    }

    /**
     * 登陆方法
     * @param userName
     * @param passWord
     * @return
     */
    @RequestMapping("/login")
    public  Object login(String userName, String passWord){
        //原始密码
        String source= passWord;
        //盐
        ByteSource credentialsSalt= ByteSource.Util.bytes(userName);
        String credentials= new SimpleHash(hashAlgorithmName, source, credentialsSalt,hashIterations ).toHex();
        Subject subject = SecurityUtils.getSubject();
        String msg="";
        if(userName!=null&&!"".equals(userName)) {
            UsernamePasswordToken token = new UsernamePasswordToken(userName, credentials);
            try {
                subject.login(token);
                msg="success";
            } catch (AuthenticationException exception) {
                //清除session
                token.clear();
                //自定义信息
                if (UnknownAccountException.class.getName().equals(exception+"")) {
                    msg = "您输入的账号不存在~";
                } else if (IncorrectCredentialsException.class.getName().equals(exception.getClass().getName())) {
                    msg = "您输入的密码不正确~";
                } else if (LockedAccountException.class.getName().equals(exception.getClass().getName()) ){
                    msg = " 您的账号已经被锁定 无法登入系统~";
                } else {
                    msg = "账号或者密码错误~";
                }
            }
        }

        // 此方法不处理登录成功,由shiro进行处理
        return msg;
    }
    //查询要注册的用户名是否已经存在
        @RequestMapping("/queryName")
    public Object queryName(String userName){

        return service.queryName(userName);
    }

    //修改密码
    @RequestMapping("/change")
    public Object change(String passWord,HttpSession session){
        Map login1 = (Map) session.getAttribute("login1");
        //盐
        ByteSource credentialsSalt= ByteSource.Util.bytes(login1.get("username"));
        String credentials= new SimpleHash(hashAlgorithmName, passWord, credentialsSalt,hashIterations ).toHex();
        int i = service.changePwd(credentials, (Integer) login1.get("id"));
        return i;
    }

    /**
     * 后台登录方法
     * @param ename
     * @param password
     * @param request
     * @return
     */
    @RequestMapping("/backLogin")
    public String backLogin(String ename, String password, HttpServletRequest request){
        System.out.println(ename+password);
        //根据登录的员工名字去数据库取数据
        Map map=service.backLogin(ename);
        //取出密码进行比较
       String passWord= (String) map.get("epassword");
       if(map==null){
           System.out.println("nouser");
        return "nouser";
       }
       if(passWord.equals(password)){
           System.out.println("success");
           //登陆成功后将emp存进session
           request.getSession().setAttribute("emp",map);
           return "success";
       }else{
           System.out.println("usererror");
           return "usererror";
       }

    }
}
