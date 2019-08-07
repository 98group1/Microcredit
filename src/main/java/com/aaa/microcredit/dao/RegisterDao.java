package com.aaa.microcredit.dao;

import com.aaa.microcredit.entity.Login;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * fileName:register
 * description:
 * author:雷建林
 * ceeateTime:2019/7/27 16:06
 */
@Repository
public interface RegisterDao {
    /**
     * 注册方法
     * @param login
     * @return
     */
    @Insert("insert into login (username,password,tel) values (#{userName},#{passWord},#{tel})")
    int addUser(Login login);

    /**
     * 查询注册时的用户名是否存在
     * @param userName
     * @return
     */
    @Select("select * from login where userName=#{userName}")
    List<Map> queryName(String userName);

    /**
     * 登陆方法：根据名字进行查询密码
     */
    @Select("select * from login where username=#{userName}")
    List<Map> query1(String userName);

    /**
     * 修改账户密码
     * @param passWord
     * @return
     */
    @Update("update login set passWord=#{passWord} where id=#{id}")
    int changePwd(String passWord,Integer id);
}

