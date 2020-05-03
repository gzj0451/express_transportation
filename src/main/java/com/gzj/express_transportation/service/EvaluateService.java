package com.gzj.express_transportation.service;

import com.gzj.express_transportation.entity.Evaluate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EvaluateService {

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
     * @param evaluate
     * @return
     */
    int insert(Evaluate evaluate);

    /**
     * 根据主键查询操作
     *
     * @param
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
     * 修改操作
     *
     * @param evaluate
     * @return
     */
    int updateByPrimaryKey(Evaluate evaluate);


    int count(String waybillNo);

    List<Evaluate> selectPage(String waybillNo);

}