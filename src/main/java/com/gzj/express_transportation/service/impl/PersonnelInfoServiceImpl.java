package com.gzj.express_transportation.service.impl;

import com.gzj.express_transportation.dao.PersonnelInfoMapper;
import com.gzj.express_transportation.entity.PersonnelInfo;
import com.gzj.express_transportation.service.PersonnelInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonnelInfoServiceImpl implements PersonnelInfoService {

    @Autowired
    private PersonnelInfoMapper personnelInfoMapper;

    /**
     * 删除操作 根据主键删除
     *
     * @param id
     * @return
     */
    @Override
    public int deleteByPrimaryKey(int id) {
        return personnelInfoMapper.deleteByPrimaryKey(id);
    }

    /**
     * 添加操作
     *
     * @param personnelInfo
     * @return
     */
    @Override
    public int insert(PersonnelInfo personnelInfo) {
        return personnelInfoMapper.insert(personnelInfo);
    }

    /**
     * 根据主键查询操作
     *
     * @param id
     * @return
     */
    @Override
    public PersonnelInfo selectByPrimaryKey(int id) {
        return personnelInfoMapper.selectByPrimaryKey(id);
    }

    /**
     * 全部查询操作
     *
     * @return
     */
    @Override
    public List<PersonnelInfo> selectAll() {
        return personnelInfoMapper.selectAll();
    }

    /**
     * 修改操作
     *
     * @param personnelInfo
     * @return
     */
    @Override
    public int updateByPrimaryKey(PersonnelInfo personnelInfo) {
        return personnelInfoMapper.updateByPrimaryKey(personnelInfo);
    }

    /**
     * 查询所有数据
     * @return
     */
    @Override
    public int count() {
        return personnelInfoMapper.count();
    }
}
