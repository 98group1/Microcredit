package com.aaa.microcredit.dao;

import com.aaa.microcredit.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    int deleteByPrimaryKey(Integer empid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer empid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 查询全部
     * @return
     */
    @Select ("select m.empid,m.ename,m.epassword,m.etel,m.ezj,m.eaddress from m_user m")
    List<Map> queryAll();

    /**
     * 分页查询
     * @param map
     * @return
     */
    List<User> queryPage(Map map);
    /**
     * 查询分页总数量
     * @param map
     * @return
     */

    int queryPageCount(Map map);

    /**
     * 根据员工id查询员工对应的角色
     * @param empid
     * @return
     */
    @Select("select roleid from m_user_role where empid=#{empid}")
    List<Integer> getRolesByUserId(int empid);

    @Select ("delete from m_user_role where empid =#{empid}")
    Integer deleteRole(@Param ("empid") Integer empid);


    @Select ("insert into m_user_role (empid,roleid) VALUES(#{empid},#{roleid})")
    Integer insertRole(@Param ("empid") Integer empid,@Param ("roleid") Integer roleid);

    int insetUserRole(Integer empid,List list);

}