package com.gzj.express_transportation.service.impl;

import com.gzj.express_transportation.dao.EvaluateMapper;
import com.gzj.express_transportation.entity.Evaluate;
import com.gzj.express_transportation.service.EvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluateServiceImpl implements EvaluateService {

    @Autowired
    private EvaluateMapper evaluateMapper;

    /**
     * 删除操作 根据主键删除
     *
     * @param id
     * @return
     */
    @Override
    public int deleteByPrimaryKey(int id) {
        return evaluateMapper.deleteByPrimaryKey(id);
    }

    /**
     * 添加操作
     *
     * @param evaluate
     * @return
     */
    @Override
    public int insert(Evaluate evaluate) {
        return evaluateMapper.insert(evaluate);
    }

    /**
     * 根据主键查询操作
     *
     * @param id
     * @return
     */
    @Override
    public Evaluate selectByPrimaryKey(int id) {
        return evaluateMapper.selectByPrimaryKey(id);
    }

    /**
     * 全部查询操作
     *
     * @return
     */
    @Override
    public List<Evaluate> selectAll() {
        return evaluateMapper.selectAll();
    }

    /**
     * 修改操作
     *
     * @param evaluate
     * @return
     */
    @Override
    public int updateByPrimaryKey(Evaluate evaluate) {
        return evaluateMapper.updateByPrimaryKey(evaluate);
    }

    /**
     * 查询所有数据
     * @return
     */
    @Override
    public int count() {
        return evaluateMapper.count();
    }
}
