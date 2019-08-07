package com.aaa.microcredit.service;

import com.aaa.microcredit.dao.RoleMapper;
import com.aaa.microcredit.entity.TreeRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


/**
 * @description: RoleServiceImpl
 * @author: ${༺评༒生༻}
 * @date: 2019-08-01 16:10
 * @Version 1.0
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService{

@Autowired
private  RoleMapper roleDao;
    
    @Override
    public List<TreeRole> getPowerTreeData() {
        //获取列表
        List<TreeRole> powers = roleDao.getPowers();
        //定义临时集合，用于存放拼装后的树数据
        List<TreeRole> tmpTreeData = new ArrayList<TreeRole> ();
        //判断
        if(powers!=null&&powers.size()>0){
            for (TreeRole power : powers) {
                //判断是否是一级节点
                if(power.getParentId()==0){

                    power.setParentName("根节点");
                    tmpTreeData.add(power);
                    //查找孩子并且绑定
                    bindChildren(power,powers);
                }
            }
        }
        return tmpTreeData;
    }

    /**
     * 递归绑定孩子过程
     * @param TreeRole
     * @param powers
     */
    private void bindChildren(TreeRole TreeRole,List<TreeRole> powers){
        List<TreeRole>  tmpChildrens = null;
        //TreeRole=系统管理  .getId() =1  系统配置 角色管理 权限管理
        for (TreeRole power : powers) {
            if(TreeRole.getRoleid()==power.getParentId()){//如果节点的父节点等于当前节点的id,该节点就是当前节点的孩子
                power.setParentName(TreeRole.getLabel());
                List<TreeRole> childrens = TreeRole.getChildren();
                //添加第一个孩子时,要判断是否已经存在孩子
                if(childrens==null||childrens.size()==0){
                    tmpChildrens = new ArrayList<>();
                    tmpChildrens.add(power);
                    TreeRole.setChildren(tmpChildrens);
                }else{
                    childrens.add(power);
                }
                //递归调用自己查找孩子并且绑定
                bindChildren(power,powers);
            }
        }

    }

    @Override
    public TreeRole getPowerById(int powerId) {
        List<TreeRole> powerList = roleDao.getPowerById(powerId);
        if(powerList!=null&&powerList.size()>0){
            return powerList.get(0);
        }
        return null;
    }


    @Override
    public int save(TreeRole TreeRole, HttpSession session) {
        // TreeRole.setAddUserName(((Map)session.getAttribute("emp")).get("username")+"");
        String nodeIds = TreeRole.getUrl();//1,7,8,2,9,10
        String[] nodeIdsArr = nodeIds.split(",");
        System.out.println("................selectKey赋值之前:" +TreeRole.getRoleid());
        //保存新加的角色信息，并且返回该角色id
        int result = roleDao.save(TreeRole);
        //System.out.println(1/0);
        System.out.println("................自增后的ID为:"+result+","+  TreeRole.getRoleid());
        //为新角色添加关联
        for (String nodeId : nodeIdsArr) {
            roleDao.saveRoleAndPower(Integer.valueOf(nodeId),TreeRole.getRoleid());
        }
        return result;
    }

    @Override
    public int update(TreeRole treeRole) {
        String nodeIds = treeRole.getUrl();//1,7,8,2,9,10
        String[] nodeIdsArr = nodeIds.split(",");
        //TreeRole.getId() 获取当前角色id
        //删除原来该角色关联的所有权限
        roleDao.deletePowersByRoleId(treeRole.getRoleid ());
        //保存角色信息
        int i=  roleDao.update(treeRole);
        //添加新的关联
        for (String nodeId : nodeIdsArr) {
            roleDao.saveRoleAndPower(Integer.valueOf(nodeId),treeRole.getRoleid());
        }
        return i;
    }

    @Override
    public int delete(int id) {
        return roleDao.delete(id);
    }

    @Override
    public List<Integer> getPowersByRoleId(int roleId) {
        return roleDao.getPowersByRoleId(roleId);
    }






}
