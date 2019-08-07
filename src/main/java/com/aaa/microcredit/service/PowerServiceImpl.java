package com.aaa.microcredit.service;


import com.aaa.microcredit.dao.PowerDao;
import com.aaa.microcredit.entity.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @description: PowerServiceImpl
 * @author: ${༺评༒生༻}
 * @date: 2019-07-19 19:30
 * @Version 1.0
 */
    @Service
    public class PowerServiceImpl implements PowerService {
        @Autowired
        private PowerDao powerDao;
    @Override
    public int deleteByPrimaryKey(Integer menuid) {
        return powerDao.deleteByPrimaryKey (menuid);
    }

    @Override
    public int insert(TreeNode record) {
        return powerDao.insert (record);
    }

    @Override
    public int insertSelective(TreeNode record) {
        return powerDao.insertSelective (record);
    }

    @Override
    public TreeNode selectByPrimaryKey(Integer menuid) {
        return powerDao.selectByPrimaryKey (menuid);
    }

    @Override
    public int updateByPrimaryKeySelective(TreeNode record) {
        return powerDao.updateByPrimaryKeySelective (record);
    }

    @Override
    public List<Map> queryAll() {
        return powerDao.queryAll ();
    }

    @Override
    public int updateByPrimaryKey(TreeNode record) {
        return powerDao.updateByPrimaryKey (record);
    }

    @Override
    public List<Map> selectRoleMenu(Integer roleid) {
        return powerDao.selectRoleMenu (roleid);
    }


    @Override
    public int insetRoleMenu(Integer roleid, List list) {
        Integer a=powerDao.deleteRoleMenu (roleid);

        for (int i = 0; i < list.size (); i++) {
            Integer integer= (Integer) list.get (i);
            powerDao.insertRoleMenu (roleid,integer);
        }
        return 1;
    }
        @Override
        public List<TreeNode> getPowerTreeData() {
            //获取树形菜单列表
            /*List<TreeNode> powers = powerDao.getPowers(empid);*/
            List<TreeNode> powers = powerDao.getPower();
            //定义临时集合，用于存放拼装后的树数据
            List<TreeNode> tmpTreeData = new ArrayList<TreeNode> ();
            //判断树形菜单是否为空
            if(powers!=null&&powers.size()>0){
                //遍历取值 power
                for (TreeNode power : powers) {
                    //判断是否是一级节点
                    if(power.getParentid ()==0){
                        //如果是一级节点  ParentId==0 就将其添加到临时集合内
                        tmpTreeData.add(power);
                        //调用bindChildren方法查找孩子并且绑定 将一级节点和全部树形菜单传入
                        bindChildren(power,powers);
                    }
                }
            }
            return tmpTreeData;
        }

    @Override
    public List<TreeNode> getPowersTreeData(Integer empid) {
//获取树形菜单列表
        /*List<TreeNode> powers = powerDao.getPowers(empid);*/
        List<TreeNode> powers = powerDao.getPowers(empid);
        //定义临时集合，用于存放拼装后的树数据
        List<TreeNode> tmpTreeData = new ArrayList<TreeNode> ();
        //判断树形菜单是否为空
        if(powers!=null&&powers.size()>0){
            //遍历取值 power
            for (TreeNode power : powers) {
                //判断是否是一级节点
                if(power.getParentid ()==0){
                    //如果是一级节点  ParentId==0 就将其添加到临时集合内
                    tmpTreeData.add(power);
                    //调用bindChildren方法查找孩子并且绑定 将一级节点和全部树形菜单传入
                    bindChildren(power,powers);
                }
            }
        }
        return tmpTreeData;
    }

        /**
         * 递归绑定孩子过程
         * @param treeNode
         * @param powers
         */
        private void bindChildren(TreeNode treeNode,List<TreeNode> powers){
            List<TreeNode>  tmpChildrens = null;
            //treeNode=系统管理  .getId() =1  系统配置 角色管理 权限管理
            //遍历全部树形菜单
            for (TreeNode power : powers) {
                //判断一级菜单的Id是否和另一节点的ParentId相等
                if(treeNode.getMenuid()==power.getParentid()){//如果节点的父节点等于当前节点的id,该节点就是当前节点的孩子

                    List<TreeNode> childrens = treeNode.getChildren();

                    //添加第一个孩子时,要判断是否已经存在孩子
                    if(childrens==null||childrens.size()==0){
                        tmpChildrens = new ArrayList<>();
                        //将符合条件的子节点加入到集合中
                        tmpChildrens.add(power);
                        treeNode.setChildren(tmpChildrens);
                    }else{
                        childrens.add(power);
                    }
                    //递归调用自己查找孩子并且绑定
                    bindChildren(power,powers);
                }
            }
        }


    @Override
    public TreeNode getPowerById(int menuid) {

        List<TreeNode> powerList=powerDao.getPowerById (menuid);
        if (powerList!=null && powerList.size ()>0){
            return powerList.get(0);
        }
        return null;
    }


}
