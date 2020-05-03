package com.gzj.express_transportation.dao;

import com.gzj.express_transportation.controller.WaybillController;
import com.gzj.express_transportation.entity.Orders;
import com.gzj.express_transportation.entity.PersonnelInfo;
import com.gzj.express_transportation.entity.Waybill;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WaybillMapper {
    /**
     * 根据主键删除操作
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
     * 根据主键全部修改操作
     *
     * @param waybill
     * @return
     */
    int updateByPrimaryKey(Waybill waybill);


    int count(@Param("waybillNo") String waybillNo, @Param("wStatus") String wStatus, @Param("role") String role, @Param("phone") String phone);

    List<Waybill> selectPage(@Param("waybillNo") String waybillNo, @Param("wStatus") String wStatus, @Param("role") String role, @Param("phone") String phone);

    Orders getCount();

}