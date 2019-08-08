package com.aaa.microcredit.service;

import com.aaa.microcredit.entity.CpInfo;

import java.util.List;
import java.util.Map;

public interface CpInfoService {
    int deleteByPrimaryKey(Integer cpId);

    int insert(CpInfo record);

    int insertSelective(CpInfo record);

    CpInfo selectByPrimaryKey(Integer cpId);

    int updateByPrimaryKeySelective(CpInfo record);

    int updateByPrimaryKey(CpInfo record);

    /**
     * 查询分页总数量
     * @param map
     * @return
     */
    int queryPageCount(Map map);


    /**
     * 查询所有
     * @return
     */
    List<CpInfo> queryAll(Map map);


    List queryAllTest();

    /**
     * 查询一审
     * @param map
     * @return
     */
    List queryStatus1(Map map);
    /**
     * 修改法人表的状态
     * @param map
     * @return
     */
    Integer updateStatus(Map map);

    /**
     * 完善公司信息方法
     * @param map
     * @return
     */
    int insertInfo(Map map);

    /**
     * 根据用户名更换相应头像
     * @param userName
     * @return
     */
    int changeHead(String userName,String headPortrait);

    /**
     * 查询公司信息
     * @return
     */
    Map selectCpInfo(String userName);
    /**
     * 修改公司信息
     * @param map
     * @return
     */
    int updataCpInfo(Map map);

    /**
     * 查询头像并显示
     * @param userName
     * @return
     */
    Map selectHead(String userName);
}
