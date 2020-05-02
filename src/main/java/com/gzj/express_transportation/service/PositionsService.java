package com.gzj.express_transportation.service;

import com.gzj.express_transportation.entity.Positions;

import java.util.List;

public interface PositionsService {

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
     * @param positions
     * @return
     */
    int insert(Positions positions);

    /**
     * 根据主键查询操作
     *
     * @param id
     * @return
     */
    Positions selectByPrimaryKey(int id);

    /**
     * 全部查询操作
     *
     * @return
     */
    List<Positions> selectAll();

    /**
     * 修改操作
     *
     * @param positions
     * @return
     */
    int updateByPrimaryKey(Positions positions);

    /**
     * 查询所有数据
     * @return
     */
    int count();
}