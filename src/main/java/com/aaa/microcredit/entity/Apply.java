package com.aaa.microcredit.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Apply {
    //贷款id
    private Integer applyId;
    //用户id
    private Integer userId;
    //还款方式
    private Integer repaymentId;
    //贷款类型
    private Integer loanType;
    //担保人姓名
    private String bondsmanName;
    //贷款状态   1未审核2审核中（一审通过二审还没开始期间）
    // 3审核通过（一审、二审都通过） 4审核不通过，即驳回（一审二审其中一个不通过就不通过）
    // 5贷款金额已到账6 待还款 7 已还款 8还款结束 9逾期
    private Integer loanStatus;
    //贷款金额
    private Double loanMoney;
    //贷款期限
    private String loanDeadline;
    //贷款时间
    private Date loanTime;
    //一审人
    private String firstCareful;
    //二审人
    private String twoCareful;
    //驳回理由
    private String reason;
    //借款描述
    private String describes;

    public Integer getApplyId() {
        return applyId;
    }

    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRepaymentId() {
        return repaymentId;
    }

    public void setRepaymentId(Integer repaymentId) {
        this.repaymentId = repaymentId;
    }

    public Integer getLoanType() {
        return loanType;
    }

    public void setLoanType(Integer loanType) {
        this.loanType = loanType;
    }

    public String getBondsmanName() {
        return bondsmanName;
    }

    public void setBondsmanName(String bondsmanName) {
        this.bondsmanName = bondsmanName == null ? null : bondsmanName.trim();
    }

    public Integer getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(Integer loanStatus) {
        this.loanStatus = loanStatus;
    }

    public Double getLoanMoney() {
        return loanMoney;
    }

    public void setLoanMoney(Double loanMoney) {
        this.loanMoney = loanMoney;
    }

    public String getLoanDeadline() {
        return loanDeadline;
    }

    public void setLoanDeadline(String loanDeadline) {
        this.loanDeadline = loanDeadline == null ? null : loanDeadline.trim();
    }

    public Date getLoanTime() {
        return loanTime;
    }

    public void setLoanTime(Date loanTime) {
        this.loanTime = loanTime;
    }

    public String getFirstCareful() {
        return firstCareful;
    }

    public void setFirstCareful(String firstCareful) {
        this.firstCareful = firstCareful == null ? null : firstCareful.trim();
    }

    public String getTwoCareful() {
        return twoCareful;
    }

    public void setTwoCareful(String twoCareful) {
        this.twoCareful = twoCareful == null ? null : twoCareful.trim();
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describe) {
        this.describes = describe == null ? null : describe.trim();
    }
}