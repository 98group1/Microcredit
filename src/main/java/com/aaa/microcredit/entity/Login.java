package com.aaa.microcredit.entity;

import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Component;

/**
 * fileName:Login
 * description:
 * author:雷建林
 * ceeateTime:2019/7/27 19:53
 */
@Component
public class Login {
    private Integer id;
    private String userName;
    private String passWord;
    private String paymentCode;
    private String tel;
    private Insert status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPaymentCode() {
        return paymentCode;
    }

    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Insert getStatus() {
        return status;
    }

    public void setStatus(Insert status) {
        this.status = status;
    }


}
