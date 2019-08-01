package com.aaa.microcredit.entity;

public class User {
    private Integer empid;

    private String ename;

    private String epassword;

    private String etel;

    private String ezj;

    private String eaddress;

    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename == null ? null : ename.trim();
    }

    public String getEpassword() {
        return epassword;
    }

    public void setEpassword(String epassword) {
        this.epassword = epassword == null ? null : epassword.trim();
    }

    public String getEtel() {
        return etel;
    }

    public void setEtel(String etel) {
        this.etel = etel == null ? null : etel.trim();
    }

    public String getEzj() {
        return ezj;
    }

    public void setEzj(String ezj) {
        this.ezj = ezj == null ? null : ezj.trim();
    }

    public String getEaddress() {
        return eaddress;
    }

    public void setEaddress(String eaddress) {
        this.eaddress = eaddress == null ? null : eaddress.trim();
    }
}