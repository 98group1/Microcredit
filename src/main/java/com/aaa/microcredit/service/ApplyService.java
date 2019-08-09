package com.aaa.microcredit.service;

import com.aaa.microcredit.entity.Apply;

import java.util.List;
import java.util.Map;

public interface ApplyService {
    //根据申请id删除
    int deleteByPrimaryKey(Integer applyId);
    //录入
    int insert(Apply record);
    //录入申请信息，可以允许某列的值为空进行录入
    int insertSelective(Apply record);
    //根据申请id进行查询出对应的申请信息
    Apply selectByPrimaryKey(Integer applyId);
    //根据申请id修改申请资料，可以允许某列传参的值为空
    int updateByPrimaryKeySelective(Apply record);
    //根据申请id修改资料
    int updateByPrimaryKey(Apply record);
    //联合字典表
    Map selectByApplyId(Integer applyId);
    //根据用户id查询申请信息
    List<Map> selectByUserId(Integer userId);

    // 后台根据用户id查询申请信息
    Map selectApplyAll(String applyId);

    /**
     * 查询出需要审核的申请信息
     * @return
     */
    List<Map> selectApply(Map map);
    /**
     * 查询出需要审核的申请信息总条数
     * @return
     */
    Integer selectApplyCount(Map map);

    /**
     * 修改申请表中的贷款状态
     * @return
     */
    Integer updateApplyStatus(Map map);
    /**
     * 申请不通过时，修改申请表中的贷款状态并填写驳回理由
     * @return
     */
    Integer updateReason(Map map);
}
