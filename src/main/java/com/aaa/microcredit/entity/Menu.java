package com.aaa.microcredit.entity;

import java.util.Date;

public class Menu {
    private Integer menuid;

    private String name;

    private Integer parentid;

    private String url;

    private String addUsername;

    private Date addTime;

    public Integer getMenuid() {
        return menuid;
    }

    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getAddUsername() {
        return addUsername;
    }

    public void setAddUsername(String addUsername) {
        this.addUsername = addUsername == null ? null : addUsername.trim();
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}