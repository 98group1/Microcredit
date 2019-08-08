package com.aaa.microcredit.controller;

import com.aaa.microcredit.entity.User;
import com.aaa.microcredit.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.rmi.server.InactiveGroupException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: UserController
 * @author: ${༺评༒生༻}
 * @date: 2019-08-01 16:12
 * @Version 1.0
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserServiceImpl service;

    /**
     * 查询全部用户
     * @return
     */
    @RequestMapping("/qury")
    public Object queryAll(){
        return service.queryAll ();
    }

    /**
     * 分页查询
     * @param map
     * @return
     */
    @RequestMapping("/page")
    public Object queryPage(@RequestBody Map map){
        System.out.println(map+"0.0.0.0.0.0.0");
        Map mapResult = new HashMap ();
        mapResult.put("empList",service.queryPage(map));
        System.out.println(service.queryPage(map).get (0)+"12121212121");
        mapResult.put("total",service.queryPageCount(map));
        System.out.println(service.queryPageCount(map)+"02020202020");
        return mapResult;
    }


    /**
     * 保存
     * @param
     * @return
     */
    @RequestMapping("/save")
    public Object save(@RequestBody User user){
        System.out.println ("000000" );
        System.out.println (user.getRoleIds ()+"11111" );
        return service.insertSelective(user);
    }


    /**
     * 修改
     * @param
     * @return
     */
    @RequestMapping("/update")
    public Object update(@RequestBody User user){
        return service.updateByPrimaryKeySelective(user);
    }
    /**
     * 删除
     * @param
     * @return
     */
    @RequestMapping("/delete")
    public Object delete(Integer empid){
        return service.deleteByPrimaryKey(empid);
    }

    /**
     * 根据用户id获取该用户关联的所有角色id
     * @param userId
     * @return
     */
    @RequestMapping("getRolesByUserId")
    public Object getRolesByUserId(Integer userId){
        return service.getRolesByUserId(userId);
    }

    /**
     * 调用service层封装OK的方法 进行分配角色的操作
     * @return
     */
    @RequestMapping("/saveRole")
    public  Object savarole(@RequestBody Map map){
        Integer empid = (Integer) map.get ("empid");
        List list= (List) map.get ("array");
        return service.insetUserRole (empid,list);
    }

}
