package com.gzj.express_transportation.service.impl;

import com.gzj.express_transportation.dao.WaybillMapper;
import com.gzj.express_transportation.entity.Waybill;
import com.gzj.express_transportation.service.WaybillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaybillServiceImpl implements WaybillService {

    @Autowired
    private WaybillMapper waybillMapper;

    /**
     * 删除操作 根据主键删除
     *
     * @param id
     * @return
     */
    @Override
    public int deleteByPrimaryKey(String id) {
        return waybillMapper.deleteByPrimaryKey(id);
    }

    /**
     * 添加操作
     *
     * @param waybill
     * @return
     */
    @Override
    public int insert(Waybill waybill) {
        return waybillMapper.insert(waybill);
    }

    /**
     * 根据主键查询操作
     *
     * @param id
     * @return
     */
    @Override
    public Waybill selectByPrimaryKey(String id) {
        return waybillMapper.selectByPrimaryKey(id);
    }

    /**
     * 全部查询操作
     *
     * @return
     */
    @Override
    public List<Waybill> selectAll() {
        return waybillMapper.selectAll();
    }

    /**
     * 修改操作
     *
     * @param waybill
     * @return
     */
    @Override
    public int updateByPrimaryKey(Waybill waybill) {
        return waybillMapper.updateByPrimaryKey(waybill);
    }

    /**
     * 查询所有数据
     * @return
     */
    @Override
    public int count() {
        return waybillMapper.count();
    }
}
