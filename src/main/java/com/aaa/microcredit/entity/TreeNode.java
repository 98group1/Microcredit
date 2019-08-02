package com.aaa.microcredit.entity;

import java.util.List;

/**
 * @description: TreeNode
 * @author: ${评生}
 * @date: 2019-07-29 19:29
 * @Version 1.0
 */
public class TreeNode {


    private Integer menuid;
    private String label;
    private Integer parentId;
    private List<TreeNode> children;
    private String url;
    private String addUserName;
    private String addTime;


    public Integer getMenuid() {
        return menuid;
    }

    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAddUserName() {
        return addUserName;
    }

    public void setAddUserName(String addUserName) {
        this.addUserName = addUserName;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "id=" + menuid +
                ", label='" + label + '\'' +
                ", parentId=" + parentId +
                ", children=" + children +
                ", url='" + url + '\'' +
                ", addUserName='" + addUserName + '\'' +
                ", addTime='" + addTime + '\'' +
                '}';
    }




}
