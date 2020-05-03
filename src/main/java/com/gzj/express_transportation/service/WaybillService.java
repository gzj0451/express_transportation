package com.gzj.express_transportation.service;

import com.gzj.express_transportation.entity.Waybill;

import java.util.List;

public interface WaybillService {

    /**
     * 删除操作 根据主键
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(String id);

    /**
     * 添加操作
     *
     * @param waybill
     * @return
     */
    int insert(Waybill waybill);

    /**
     * 根据主键查询操作
     *
     * @param id
     * @return
     */
    Waybill selectByPrimaryKey(String id);

    /**
     * 全部查询操作
     *
     * @return
     */
    List<Waybill> selectAll();

    /**
     * 修改操作
     *
     * @param waybill
     * @return
     */
    int updateByPrimaryKey(Waybill waybill);


    int count(String waybillNo, String wStatus, String role, String phone);
    List<Waybill> selectPage(String waybillNo, String wStatus, String role, String phone);
}