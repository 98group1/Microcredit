package com.aaa.microcredit.controller;


import com.aaa.microcredit.entity.TreeNode;
import com.aaa.microcredit.service.PowerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * @description: PowerController
 * @author: ${评生}
 * @date: 2019-07-29 19:29
 * @Version 1.0
 */
@RestController
@RequestMapping("power")
public class PowerController {
    @Autowired
    private PowerServiceImpl powerService;

    /*
     * 查询
     * */
    @RequestMapping("/qury")
    public Object queryAll(){
        return powerService.queryAll ();


    }


    /**
     * 保存
     * @param
     * @return
     */
    @RequestMapping("/save")
    public Object save(@RequestBody TreeNode menu){
        return powerService.insert(menu);
    }


    /**
     * 修改
     * @param
     * @return
     */
    @RequestMapping("/update")
    public Object update(@RequestBody TreeNode menu){
        return powerService.updateByPrimaryKeySelective(menu);
    }
    /**
     * 删除
     * @param
     * @return
     */
    @RequestMapping("/delete")
    public Object delete(Integer menuid){
        return powerService.deleteByPrimaryKey (menuid);
    }

    /**
     * 调用Service层封装OK的方法 进行分配角色的操作
     * @return
     */
    @RequestMapping("/saveRole")
    public  Object savarole(@RequestBody Map map){
        Integer roleid = (Integer) map.get ("roleid");
        List list= (List) map.get ("array");
        return powerService.insetRoleMenu (roleid,list);
    }
    /**
     * 获取权限菜单树数据
     * @return
     */
    @RequestMapping("/tree")
    public Object tree(){
        return powerService.getPowerTreeData();
    }

    /*getPowersTreeData*/

    @RequestMapping("/setree")
    public Object setree(HttpServletRequest request){
        Map emp = (Map) request.getSession().getAttribute("emp");
        Integer empid= (Integer) emp.get("empid");
        return powerService.getPowersTreeData(empid);
    }


    /**
     * 获取权限根据ID
     * @param powerId
     * @return
     */
    @RequestMapping("getPowerById")
    public Object getPowerById(Integer powerId){
        return powerService.getPowerById(powerId);
    }
}
