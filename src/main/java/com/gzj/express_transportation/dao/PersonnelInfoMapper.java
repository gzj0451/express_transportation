package com.gzj.express_transportation.dao;

import com.gzj.express_transportation.entity.PersonnelInfo;
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

    /**
     * 查询所有数据
     * @return
     */
    int count();
}