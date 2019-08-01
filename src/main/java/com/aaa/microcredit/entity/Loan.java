package com.aaa.microcredit.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Loan {
    private Integer lId;

    private Integer applyId;

    private Integer cpId;

    private Integer loanType;

    private Integer rType;

    private Integer repaymentId;

    private BigDecimal loanMoney;

    private BigDecimal rMoney;

    private Integer zPeriobs;

    private BigDecimal rCapital;

    private Date applyTime;

    private Date loanTime;

    private Integer status;

    public Integer getlId() {
        return lId;
    }

    public void setlId(Integer lId) {
        this.lId = lId;
    }

    public Integer getApplyId() {
        return applyId;
    }

    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
    }

    public Integer getCpId() {
        return cpId;
    }

    public void setCpId(Integer cpId) {
        this.cpId = cpId;
    }

    public Integer getLoanType() {
        return loanType;
    }

    public void setLoanType(Integer loanType) {
        this.loanType = loanType;
    }

    public Integer getrType() {
        return rType;
    }

    public void setrType(Integer rType) {
        this.rType = rType;
    }

    public Integer getRepaymentId() {
        return repaymentId;
    }

    public void setRepaymentId(Integer repaymentId) {
        this.repaymentId = repaymentId;
    }

    public BigDecimal getLoanMoney() {
        return loanMoney;
    }

    public void setLoanMoney(BigDecimal loanMoney) {
        this.loanMoney = loanMoney;
    }

    public BigDecimal getrMoney() {
        return rMoney;
    }

    public void setrMoney(BigDecimal rMoney) {
        this.rMoney = rMoney;
    }

    public Integer getzPeriobs() {
        return zPeriobs;
    }

    public void setzPeriobs(Integer zPeriobs) {
        this.zPeriobs = zPeriobs;
    }

    public BigDecimal getrCapital() {
        return rCapital;
    }

    public void setrCapital(BigDecimal rCapital) {
        this.rCapital = rCapital;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Date getLoanTime() {
        return loanTime;
    }

    public void setLoanTime(Date loanTime) {
        this.loanTime = loanTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}