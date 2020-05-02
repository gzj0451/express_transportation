package com.gzj.express_transportation.dao;

import com.gzj.express_transportation.entity.Evaluate;
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
     * 根据主键全部修改操作
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