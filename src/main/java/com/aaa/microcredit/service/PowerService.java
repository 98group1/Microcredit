package com.aaa.microcredit.service;


import com.aaa.microcredit.entity.TreeNode;

import java.util.List;
import java.util.Map;

/**
 * @description: PowerService
 * @author: ${༺评༒生༻}
 * @date: 2019-07-19 19:30
 * @Version 1.0
 */
public interface PowerService {
    int deleteByPrimaryKey(Integer menuid);

    int insert(TreeNode record);

    int insertSelective(TreeNode record);

    TreeNode selectByPrimaryKey(Integer menuid);

    int updateByPrimaryKeySelective(TreeNode record);

    int updateByPrimaryKey(TreeNode record);

    List<Map> queryAll();

    List<Map> selectRoleMenu(Integer roleid);
    int insetRoleMenu(Integer roleid,List list);

    /**
     * 获取所有权限
     * @return
     */
    /*List<TreeNode> getPowerTreeData(Integer  empid);*/
    //根据用户Id查询对应的角色 和权限
    List<TreeNode> getPowersTreeData(Integer empid);
    //直接查询全部的权限
    List<TreeNode> getPowerTreeData();

    TreeNode getPowerById(int menuid);
}
