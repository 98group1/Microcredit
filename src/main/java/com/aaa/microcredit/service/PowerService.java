package com.aaa.microcredit.service;


import com.aaa.microcredit.entity.TreeNode;

import java.util.List;

/**
 * @description: PowerService
 * @author: ${༺评༒生༻}
 * @date: 2019-07-19 19:30
 * @Version 1.0
 */
public interface PowerService {

    /**
     * 获取所有权限
     * @return
     */
    List<TreeNode> getPowerTreeData();
}
