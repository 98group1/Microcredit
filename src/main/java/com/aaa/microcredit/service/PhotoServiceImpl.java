package com.aaa.microcredit.service;

import com.aaa.microcredit.dao.PhotoMapper;
import com.aaa.microcredit.entity.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotoServiceImpl implements PhotoService {
    @Autowired
    private PhotoMapper photoMapper;

    /**
     * 删除
     * @param id
     * @return
     */
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return photoMapper.deleteByPrimaryKey(id);
    }

    /**
     * 录入
     * @param record
     * @return 返回结果
     */
    @Override
    public int insert(Photo record) {
        return photoMapper.insert(record);
    }

    /**
     * 录入，该方法比上述录入更灵活
     * @param record
     * @return
     */
    @Override
    public int insertSelective(Photo record) {
        return photoMapper.insertSelective(record);
    }

    /**
     * 单个查询
     * @param id
     * @return
     */
    @Override
    public Photo selectByPrimaryKey(Integer id) {
        return photoMapper.selectByPrimaryKey(id);
    }

    /**
     * 修改，该方法更灵活
     * @param record
     * @return
     */
    @Override
    public int updateByPrimaryKeySelective(Photo record) {
        return photoMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 修改
     * @param record
     * @return
     */
    @Override
    public int updateByPrimaryKey(Photo record) {
        return photoMapper.updateByPrimaryKey(record);
    }
}
