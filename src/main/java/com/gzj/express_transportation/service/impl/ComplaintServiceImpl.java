package com.gzj.express_transportation.service.impl;

import com.gzj.express_transportation.dao.ComplaintMapper;
import com.gzj.express_transportation.entity.Complaint;
import com.gzj.express_transportation.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    @Autowired
    private ComplaintMapper complaintMapper;

    /**
     * 删除操作 根据主键删除
     *
     * @param id
     * @return
     */
    @Override
    public int deleteByPrimaryKey(int id) {
        return complaintMapper.deleteByPrimaryKey(id);
    }

    /**
     * 添加操作
     *
     * @param complaint
     * @return
     */
    @Override
    public int insert(Complaint complaint) {
        return complaintMapper.insert(complaint);
    }

    /**
     * 根据主键查询操作
     *
     * @param id
     * @return
     */
    @Override
    public Complaint selectByPrimaryKey(int id) {
        return complaintMapper.selectByPrimaryKey(id);
    }

    /**
     * 全部查询操作
     *
     * @return
     */
    @Override
    public List<Complaint> selectAll() {
        return complaintMapper.selectAll();
    }

    /**
     * 修改操作
     *
     * @param complaint
     * @return
     */
    @Override
    public int updateByPrimaryKey(Complaint complaint) {
        return complaintMapper.updateByPrimaryKey(complaint);
    }

    /**
     * 查询所有数据
     * @return
     */
    @Override
    public int count() {
        return complaintMapper.count();
    }
}
