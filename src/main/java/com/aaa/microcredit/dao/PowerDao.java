package com.aaa.microcredit.dao;



import com.aaa.microcredit.entity.TreeNode;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @description: PowerDao
 * @author: ${评生}
 * @date: 2019-07-29 19:29
 * @Version 1.0
 */
@Repository
public interface PowerDao {

    int deleteByPrimaryKey(Integer menuid);

    int insert(TreeNode record);

    int insertSelective(TreeNode record);

    TreeNode selectByPrimaryKey(Integer menuid);

    int updateByPrimaryKeySelective(TreeNode record);

    int updateByPrimaryKey(TreeNode record);

//查询全部
/*@Select ("SELECT menuid,parentid,`name` label,url,add_username addUserName,add_time addTime from m_menu")*/


    //根据角色Id查询对应的权限Id
    @Select("select menuid from m_role_menu where roleid=${roleid}")
    List<Map> selectRoleMenu(@Param("roleid")Integer roleid);

    //根据角色Id删除中间表中的数据
    @Select ("delete from    m_role_menu where roleid=#{roleid}")
    Integer deleteRoleMenu(@Param ("roleid") Integer roleid);

    //根绝角色Id 和权限id 在中间表中录入数据
    @Select ("insert into m_role_menu (roleid,menuid) VALUES(#{roleid},#{menuid})")
    Integer insertRoleMenu(@Param ("roleid") Integer empid,@Param ("menuid") Integer roleid);

    int insetRoleMenu(Integer roleid,List list);
    List<Map> queryAll();
    /**
     * 获取所有权限
     * @return  as   可理解为：用作、当成，作为；一般是重命名列名或者表名。（主要为了查询方便）
      */
   @Select ("select  mu.ename,mr.`name`  rolename,mm.menuid menuid,mm.`name` as label,mm.parentid parentid,mm.url url,mm.add_username addUserName,mm.add_time addTime    from m_user mu join m_user_role mur on mu.empid=mur.empid\n" +
           "join m_role mr on mur.roleid=mr.roleid\n" +
           "join m_role_menu mrm on mr.roleid=mrm.roleid\n" +
           "join m_menu mm on mm.menuid=mrm.menuid where mu.empid=#{empid};")
    List<TreeNode> getPowers(@Param ("empid") Integer empid);
   //查询全部
    @Select ("SELECT menuid,parentid,`name` label,url,add_username addUserName,add_time addTime from m_menu")
    List<TreeNode> getPower();


    /**
     * 根据Id查询
     * @param menuid
     * @return
     */
    @Select ("SELECT menuid,parentid,`name` label,url,add_username addUserName,add_time addTime from m_menu where menuid=#{menuid}")
    List<TreeNode> getPowerById(int menuid);
}