package com.aaa.microcredit.dao;



import com.aaa.microcredit.entity.TreeNode;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description: PowerDao
 * @author: ${༺评༒生༻}
 * @date: 2019-07-29 19:29
 * @Version 1.0
 */
@Repository
public interface PowerDao {

    /**
     * 获取所有权限
     * @return  as   可理解为：用作、当成，作为；一般是重命名列名或者表名。（主要为了查询方便）
      */
    @Select("select id,name as label,parentid,url,add_username addUserName,add_time addTime   from tb_power")
    List<TreeNode> getPowers();
}