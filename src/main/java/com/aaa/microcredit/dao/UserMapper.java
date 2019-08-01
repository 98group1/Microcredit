package com.aaa.microcredit.dao;

import com.aaa.microcredit.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer empid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer empid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}