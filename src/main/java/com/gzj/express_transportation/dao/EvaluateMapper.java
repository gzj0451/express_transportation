package com.gzj.express_transportation.dao;

import com.gzj.express_transportation.entity.Evaluate;
import com.gzj.express_transportation.entity.Waybill;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaluateMapper {
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
     * @param evaluate
     * @return
     */
    int insert(Evaluate evaluate);

    /**
     * 根据主键查询操作
     *
     * @param waybillNo
     * @return
     */
    Evaluate selectByPrimaryKey(String waybillNo);

    /**
     * 全部查询操作
     *
     * @return
     */
    List<Evaluate> selectAll();

    /**
     * 根据主键全部修改操作
     *
     * @param evaluate
     * @return
     */
    int updateByPrimaryKey(Evaluate evaluate);

    int count(@Param("waybillNo") String waybillNo);

    List<Evaluate> selectPage(@Param("waybillNo") String waybillNo);
}