package com.baihy.service.impl;

import com.baihy.entity.Dept;
import com.baihy.mapper.DeptMapper;
import com.baihy.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: microservice-cloud
 * @packageName: com.baihy.service.impl
 * @Description:
 * @author: huayang.bai
 * @date: 2019-03-09 17:15
 */
@Service
public class DeptServiceImpl implements IDeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public boolean add(Dept dept) {
        return deptMapper.insert(dept) > 0 ? true : false;
    }

    @Override
    public Dept get(Integer id) {
        return deptMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Dept> list() {
        return deptMapper.queryList();
    }
}
