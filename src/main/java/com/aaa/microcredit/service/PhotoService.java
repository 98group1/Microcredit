package com.aaa.microcredit.service;

import com.aaa.microcredit.entity.Photo;

public interface PhotoService {
    //根据主键删除上传的公司资料
    int deleteByPrimaryKey(Integer id);
    //录入
    int insert(Photo record);
    //录入图片名称
    int insertSelective(Photo record);
    //根据主键查询
    Photo selectByPrimaryKey(Integer id);
    //修改信息
    int updateByPrimaryKeySelective(Photo record);
    //修改
    int updateByPrimaryKey(Photo record);
}
