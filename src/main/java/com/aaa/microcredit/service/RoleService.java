package com.aaa.microcredit.service;

import com.aaa.microcredit.entity.TreeRole;

import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * @description: RoleService
 * @author: ${༺评༒生༻}
 * @date: 2019-08-01 16:10
 * @Version 1.0
 */
public interface RoleService {

    /**
     * 获取所有权限
     * @return
     */
    List<TreeRole> getPowerTreeData();

    /**
     * 根据id查询
     * @param powerId
     * @return
     */
    TreeRole getPowerById(int powerId);

    /**
     * 添加
     * @param TreeRole
     * @param session
     * @return
     */
    int save(TreeRole TreeRole, HttpSession session);

    /**
     * 更新
     * @param treeRole
     * @return
     */
    int update(TreeRole treeRole);

    /**
     * 删除
     * @param id
     * @return
     */
    int delete(int id);
    /**
     * 根据角色ID查询以前该角色关联的所有权限
     * @param roleId
     * @return
     */
    List<Integer> getPowersByRoleId(int roleId);
}
