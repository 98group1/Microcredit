package com.aaa.microcredit.service;

import com.aaa.microcredit.dao.UserMapper;
import com.aaa.microcredit.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @description: UserServiceImpl
 * @author: ${༺评༒生༻}
 * @date: 2019-08-01 16:08
 * @Version 1.0
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;

    @Override
    public int deleteByPrimaryKey(Integer empid) {
        return mapper.deleteByPrimaryKey (empid);
    }

    @Override
    public int insert(User record) {
        return mapper.insert (record);
    }


  @Override
  public int insertSelective(User record) {
      //添加人员
      int i = mapper.insertSelective(record);
      if(record.getRoleIds ()!=null&&!"".equals(record.getRoleIds())) {
          //解析roleid字符串
          String roleIds = record.getRoleIds();
          String[] roleIdsArr = roleIds.split(",");
          //批量添加用户角色关联
          for (String roleId : roleIdsArr) {
              mapper.insertRole(record.getEmpid (), Integer.valueOf(roleId));
          }
      }
      return i;
  }

    @Override
    public User selectByPrimaryKey(Integer empid) {
        return mapper.selectByPrimaryKey (empid);
    }

    @Override
    public List<Map> queryAll() {
        return mapper.queryAll ();
    }



    @Override
    public List<Integer> getRolesByUserId(int empid) {
        return mapper.getRolesByUserId(empid);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        //更新人员信息
        int i = mapper.updateByPrimaryKeySelective(record);
        if(record.getRoleIds()!=null&&!"".equals(record.getRoleIds())) {
            //根据用户id删除该用户原来关联的角色id
            mapper.deleteRole(record.getEmpid());
            //解析roleid字符串
            String roleIds = record.getRoleIds();
            String[] roleIdsArr = roleIds.split(",");
            //批量添加用户角色关联
            for (String roleId : roleIdsArr) {
                mapper.insertRole(record.getEmpid(), Integer.valueOf(roleId));
            }
        }
        return i;
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return mapper.updateByPrimaryKey (record);
    }



    @Override
    public int insetUserRole(Integer empid, List list) {
        /**
         * 根据用户Id删除中间表的数据
         */
        System.out.println (empid );
        Integer i1 = mapper.deleteRole (empid);
        /**
         * 根据用户Id进行循环分配角色操作
         */
        for (int i = 0; i <list.size () ; i++) {
            Integer integer= (Integer) list.get (i);
            System.out.println (i+"CCCCCC"+empid+"DDDDDD"+list );
            mapper.insertRole (empid,integer);
        }

        return 1;
    }

    @Override
    public List<User> queryPage(Map map) {
        return mapper.queryPage (map);
    }

    @Override
    public int queryPageCount(Map map) {
        return mapper.queryPageCount (map);
    }
}
