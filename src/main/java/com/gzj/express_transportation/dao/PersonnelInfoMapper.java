package com.gzj.express_transportation.dao;

import com.gzj.express_transportation.entity.PersonnelInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonnelInfoMapper {
    /**
     * 根据主键删除操作
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
     * 根据主键全部修改操作
     *
     * @param personnelInfo
     * @return
     */
    int updateByPrimaryKey(PersonnelInfo personnelInfo);


    int count(@Param("phone") String phone, @Param("name") String name, @Param("sex") String sex,@Param("role") String role);


    List<PersonnelInfo> selectPage(@Param("phone") String phone, @Param("name") String name, @Param("sex") String sex,@Param("role") String role);

    PersonnelInfo doLogin(@Param("phone") String phone,@Param("password") String password);


}