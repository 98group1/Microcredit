package com.aaa.microcredit.dao;

import com.aaa.microcredit.entity.TreeRole;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RoleMapper {

    /**
     * 获取所有角色
     * @return
     */
    @Select("select roleid,name as label,remark,state,parentid,add_username addUserName,add_time addTime   from m_role")
    List<TreeRole> getPowers();

    /**
     * 根据id查询
     * @param roleId
     * @return
     */
    @Select("select roleid,name as label,remark,state,parentid,add_username addUserName,add_time addTime   from m_role   where roleid=#{powerId}")
    List<TreeRole> getPowerById(int roleId);


    /**
     * 添加
     * @param treeRole
     * @return
     */
    //useGeneratedKeys 参数只针对 insert 语句生效，默认为 false。当设置为 true 时，表示如果插入的表以自增列为主键，
    // 则允许 JDBC 支持自动生成主键，并可将自动生成的主键返回。
    @SelectKey(statement = "select last_insert_id()",keyProperty = "roleid",before = false,resultType = int.class)
    @Insert("insert into m_role(name,parentid,add_Time) values(#{label},#{parentId},now())")
    int save(TreeRole treeRole);



    /**
     * 更新
     * @param treeRole
     * @return
     */

    @Update("update m_role set name=#{label},parentid =#{parentId} where roleid=#{roleid}")
    int update(TreeRole treeRole);

    /**
     * 删除
     * @param roleid
     * @return
     */
    @Delete("delete from m_role where roleid=#{roleid}")
    int delete(int roleid);

    /**
     * 向关联表添加数据
     * @param powerId
     * @param roleId
     * @return
     */
    @Insert("insert into m_role_menu values(null,#{roleId},#{powerId})")
    int saveRoleAndPower(@Param("powerId") int powerId,@Param("roleId") int roleId);

    /**
     * 根据角色ID删除以前该角色关联的所有权限
     * @param roleid
     * @return
     */
    @Delete("delete from m_role_menu where roleid=#{roleid}")
    int deletePowersByRoleId(int roleid);

    /**
     * 根据角色ID查询以前该角色关联的所有权限
     * @param roleId
     * @return
     */
    @Select("select menuid from m_role_menu where roleid=#{roleId}")
    List<Integer> getPowersByRoleId(int roleId);
}