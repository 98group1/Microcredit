package com.aaa.microcredit.service;

import com.aaa.microcredit.dao.ApplyMapper;
import com.aaa.microcredit.entity.Apply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplyServiceImpl implements ApplyService {
    //自动注入AppleMapper
    @Autowired
    private ApplyMapper applyMapper;
    //根据申请id删除申请信息
    @Override
    public int deleteByPrimaryKey(Integer applyId) {
        return applyMapper.deleteByPrimaryKey(applyId);
    }
    //录入
    @Override
    public int insert(Apply record) {
        return applyMapper.insert(record);
    }
    //录入申请信息，可以允许某列的值为空进行录入
    @Override
    public int insertSelective(Apply record) {
        return applyMapper.insertSelective(record);
    }
    //根据申请id进行查询出对应的申请信息
    @Override
    public Apply selectByPrimaryKey(Integer applyId) {
        return applyMapper.selectByPrimaryKey(applyId);
    }
    //根据申请id修改申请资料，可以允许某列传参的值为空
    @Override
    public int updateByPrimaryKeySelective(Apply record) {
        return applyMapper.updateByPrimaryKeySelective(record);
    }
    //根据申请id修改资料
    @Override
    public int updateByPrimaryKey(Apply record) {
        return applyMapper.updateByPrimaryKey(record);
    }
}
