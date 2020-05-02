package com.gzj.express_transportation.dao;

import com.gzj.express_transportation.entity.Positions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PositionsMapper {
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
     * 根据主键全部修改操作
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