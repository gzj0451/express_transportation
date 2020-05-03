package com.gzj.express_transportation.dao;

import com.gzj.express_transportation.entity.Evaluate;
import com.gzj.express_transportation.entity.Positions;
import org.apache.ibatis.annotations.Param;
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


    int count(@Param("waybillNo") String waybillNo);

    List<Positions> selectPage(@Param("waybillNo") String waybillNo);
    Positions doLogin(@Param("phone") String phone,@Param("password") String password);
}