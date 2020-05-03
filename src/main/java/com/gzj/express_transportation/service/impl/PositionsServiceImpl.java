package com.gzj.express_transportation.service.impl;

import com.gzj.express_transportation.dao.PositionsMapper;
import com.gzj.express_transportation.entity.Evaluate;
import com.gzj.express_transportation.entity.Positions;
import com.gzj.express_transportation.service.PositionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionsServiceImpl implements PositionsService {

    @Autowired
    private PositionsMapper positionsMapper;

    /**
     * 删除操作 根据主键删除
     *
     * @param id
     * @return
     */
    @Override
    public int deleteByPrimaryKey(int id) {
        return positionsMapper.deleteByPrimaryKey(id);
    }

    /**
     * 添加操作
     *
     * @param positions
     * @return
     */
    @Override
    public int insert(Positions positions) {
        return positionsMapper.insert(positions);
    }

    /**
     * 根据主键查询操作
     *
     * @param id
     * @return
     */
    @Override
    public Positions selectByPrimaryKey(int id) {
        return positionsMapper.selectByPrimaryKey(id);
    }

    /**
     * 全部查询操作
     *
     * @return
     */
    @Override
    public List<Positions> selectAll() {
        return positionsMapper.selectAll();
    }

    /**
     * 修改操作
     *
     * @param positions
     * @return
     */
    @Override
    public int updateByPrimaryKey(Positions positions) {
        return positionsMapper.updateByPrimaryKey(positions);
    }

    @Override
    public int count(String waybillNo) {
        return positionsMapper.count(waybillNo);
    }

    @Override
    public List<Positions> selectPage(String waybillNo) {
        return positionsMapper.selectPage(waybillNo);
    }
}
