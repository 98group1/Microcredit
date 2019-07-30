package com.aaa.microcredit.entity;

import lombok.Data;

@Data
public class Bondsman {
    private Integer bId;

    private Integer applyId;

    private String bName;

    private String bSex;

    private Integer bAge;

    private String bTel;

    private String bZj;

    private String bAddress;

    private String income;

    private Integer status;

    public Integer getbId() {
        return bId;
    }

    public void setbId(Integer bId) {
        this.bId = bId;
    }

    public Integer getApplyId() {
        return applyId;
    }

    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName == null ? null : bName.trim();
    }

    public String getbSex() {
        return bSex;
    }

    public void setbSex(String bSex) {
        this.bSex = bSex == null ? null : bSex.trim();
    }

    public Integer getbAge() {
        return bAge;
    }

    public void setbAge(Integer bAge) {
        this.bAge = bAge;
    }

    public String getbTel() {
        return bTel;
    }

    public void setbTel(String bTel) {
        this.bTel = bTel == null ? null : bTel.trim();
    }

    public String getbZj() {
        return bZj;
    }

    public void setbZj(String bZj) {
        this.bZj = bZj == null ? null : bZj.trim();
    }

    public String getbAddress() {
        return bAddress;
    }

    public void setbAddress(String bAddress) {
        this.bAddress = bAddress == null ? null : bAddress.trim();
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income == null ? null : income.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}