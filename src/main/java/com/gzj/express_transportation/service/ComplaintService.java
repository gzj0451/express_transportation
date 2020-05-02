package com.gzj.express_transportation.service;

import com.gzj.express_transportation.entity.Complaint;

import java.util.List;

public interface ComplaintService {

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
     * @param complaint
     * @return
     */
    int insert(Complaint complaint);

    /**
     * 根据主键查询操作
     *
     * @param id
     * @return
     */
    Complaint selectByPrimaryKey(int id);

    /**
     * 全部查询操作
     *
     * @return
     */
    List<Complaint> selectAll();

    /**
     * 修改操作
     *
     * @param complaint
     * @return
     */
    int updateByPrimaryKey(Complaint complaint);

    /**
     * 查询所有数据
     * @return
     */
    int count();
}