package com.aaa.microcredit.service;

import com.aaa.microcredit.entity.Login;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * fileName:RegisterService
 * description:
 * author:雷建林
 * ceeateTime:2019/7/27 16:16
 */
public interface RegisterService {
    /**
     * 注册方法
     * @param login
     * @return
     */
    int addUser(Login login);

    /**
     * 登陆方法
     * @param userName
     * @return
     */
    List<Map> query1(String userName);

    /**
     * 查询注册时的用户名是否存在
     * @param userName
     * @return
     */
    String queryName(String userName);

    /**
     * 修改账户密码
     * @param passWord
     * @return
     */
    int changePwd(String passWord,Integer id);

    /**
     * 修改账户支付密码
     * @param paymentCode
     * @param id
     * @return
     */
    int changePayCode(String paymentCode,Integer id);

    /**
     * 根据员工姓名查出数据
     * @param eName
     * @return
     */
    Map backLogin(String eName);
}
