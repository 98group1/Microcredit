package com.aaa.microcredit.controller;


import com.aaa.microcredit.entity.TreeRole;
import com.aaa.microcredit.service.RoleService;
import com.aaa.microcredit.service.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @description: RoleControlle
 * @author: ${༺评༒生༻}
 * @date: 2019-08-01 16:13
 * @Version 1.0
 */
@RestController
@RequestMapping("role")
public class RoleControlle {

    @Autowired
    private RoleService roleService;

    /**
     * 获取角色角色菜单树数据
     * @return
     */
    @RequestMapping("tree")
    public Object tree(){

        return roleService.getPowerTreeData();
    }

    /**
     * 获取角色根据ID
     * @param powerId
     * @return
     */
    @RequestMapping("getPowerById")
    public Object getPowerById(Integer powerId){
        return roleService.getPowerById(powerId);
    }

    /**
     * 添加
     * @param treeRole
     * @return
     */
    @RequestMapping("save")
    public Object save(@RequestBody TreeRole treeRole, HttpSession session){

        return roleService.save(treeRole,session);
    }

    /**
     * 更新
     * @param treeRole
     * @return
     */
    @RequestMapping("update")
    public Object update(@RequestBody TreeRole treeRole){
        System.out.println ("111111" );
        System.out.println ("11111"+ treeRole);

        return roleService.update(treeRole);
    }

    /**
     * 删除
     * @param roleid
     * @return
     */
    @RequestMapping("delete")
    public Object delete(Integer roleid){


        return roleService.delete(roleid);
    }

    /**
     * 根据角色ID查询以前该角色关联的所有权限
     * @param roleId
     * @return
     */
    @RequestMapping("getPowersByRoleId")
    public Object getPowersByRoleId(Integer roleId){
        System.out.println (roleId+"111111" );
        return roleService.getPowersByRoleId(roleId);
    }


    


}