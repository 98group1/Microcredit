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


    @RequestMapping("/qury")
    public Object queryAll(){
        return service.queryAll ();


    }


    /**
     * 保存
     * @param
     * @return
     */
    @RequestMapping("/save")
    public Object save(@RequestBody User user){
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
     * 根据员工id查询员工角色
     * @param map
     * @return
     */
    @RequestMapping("/selectUserRole")
    public Object selectUserRole(@RequestBody Map map){
        Integer empid= (Integer) map.get("empid");
        System.out.println (empid );
        List<Map> mapList = service.selectUserRole (empid);
        List checked= new ArrayList();
        for (Map map1 : mapList) {
            Integer roleid = (Integer) map1.get ("roleid");
            checked.add (roleid);
        }
        System.out.println (checked );
        return checked;
    }


    /**
     * 调用service层封装OK的方法 进行分配角色的操作
     * @return
     */
    @RequestMapping("/saveRole")
    public  Object savarole(@RequestBody Map map){
        Integer empid = (Integer) map.get ("empid");
        System.out.println (empid+"AAAAAA");
        List list= (List) map.get ("array");
        System.out.println (list+"BBBBBBB" );
        return service.insetUserRole (empid,list);
    }

}
