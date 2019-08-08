package com.aaa.microcredit.service;

import com.aaa.microcredit.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @description: UserService
 * @author: ${༺评༒生༻}
 * @date: 2019-08-01 16:08
 * @Version 1.0
 */
public interface UserService {

    int deleteByPrimaryKey(Integer empid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer empid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<Map> queryAll();

    List<User> queryPage(Map map);
    int queryPageCount(Map map);

    List<Integer> getRolesByUserId(int empid);

    int insetUserRole(Integer empid,List list);
}
