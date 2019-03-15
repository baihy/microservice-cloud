package com.baihy.service;

import com.baihy.entity.Dept;

import java.util.List;

/**
 * @ProjectName: microservice-cloud
 * @packageName: com.baihy.service
 * @Description:
 * @author: huayang.bai
 * @date: 2019-03-09 17:13
 */
public interface IDeptService {
    
    boolean add(Dept dept);

    Dept get(Integer id);

    List<Dept> list();

}
