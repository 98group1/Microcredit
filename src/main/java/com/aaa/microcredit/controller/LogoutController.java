package com.aaa.microcredit.controller;

import org.apache.shiro.web.session.HttpServletSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * fileName:LogoutController
 * description:
 * author:雷建林
 * ceeateTime:2019/8/8 15:06
 */
@Controller
@RequestMapping("logout")
public class LogoutController {

    @RequestMapping("logout1")
    @ResponseBody
    public Object logout(HttpServletRequest request){
        request.getSession().removeAttribute("login1");
        return "true";
    }
}
