package com.aaa.microcredit.entity;




import java.util.Date;
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
    private Integer parentid;
    private List<TreeNode> children;
    private String url;
    private String addUserName;
    private Date addTime;


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

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
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

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "menuid=" + menuid +
                ", label='" + label + '\'' +
                ", parentid=" + parentid +
                ", children=" + children +
                ", url='" + url + '\'' +
                ", addUserName='" + addUserName + '\'' +
                ", addTime=" + addTime +
                '}';
    }
}
