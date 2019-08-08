package com.aaa.microcredit.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Platform {
    private Integer pId;

    private Integer loanid;

    private Integer moneytype;

    private BigDecimal changemoney;

    private Date changeTime;

    private BigDecimal availmoney;

    private String describes;

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer getLoanid() {
        return loanid;
    }

    public void setLoanid(Integer loanid) {
        this.loanid = loanid;
    }

    public Integer getMoneytype() {
        return moneytype;
    }

    public void setMoneytype(Integer moneytype) {
        this.moneytype = moneytype;
    }

    public BigDecimal getChangemoney() {
        return changemoney;
    }

    public void setChangemoney(BigDecimal changemoney) {
        this.changemoney = changemoney;
    }

    public Date getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(Date changeTime) {
        this.changeTime = changeTime;
    }

    public BigDecimal getAvailmoney() {
        return availmoney;
    }

    public void setAvailmoney(BigDecimal availmoney) {
        this.availmoney = availmoney;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes == null ? null : describes.trim();
    }
}