package com.gzj.express_transportation.service;

import com.gzj.express_transportation.entity.PersonnelInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PersonnelInfoService {

    /**
     * 删除操作 根据主键
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(int id);

    /**
     * 添加操作
     *
     * @param personnelInfo
     * @return
     */
    int insert(PersonnelInfo personnelInfo);

    /**
     * 根据主键查询操作
     *
     * @param id
     * @return
     */
    PersonnelInfo selectByPrimaryKey(int id);

    /**
     * 全部查询操作
     *
     * @return
     */
    List<PersonnelInfo> selectAll();

    /**
     * 修改操作
     *
     * @param personnelInfo
     * @return
     */
    int updateByPrimaryKey(PersonnelInfo personnelInfo);

    int count(String phone,String name, String sex,String role);

    PersonnelInfo doLogin(String phone,String password);
    List<PersonnelInfo> selectPage(String phone, String name, String sex, String role);

}