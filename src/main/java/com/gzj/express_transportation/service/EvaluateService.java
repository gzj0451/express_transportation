package com.gzj.express_transportation.service;

import com.gzj.express_transportation.entity.Evaluate;

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
     * @param id
     * @return
     */
    Evaluate selectByPrimaryKey(int id);

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

    /**
     * 查询所有数据
     * @return
     */
    int count();
}