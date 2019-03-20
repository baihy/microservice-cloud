package com.baihy.cloud.controller;

import com.baihy.entity.Dept;
import com.baihy.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: microservice-cloud
 * @packageName: com.baihy.cloud.controller
 * @Description:
 * @author: huayang.bai
 * @date: 2019-03-09 17:50
 */
@RestController
@RequestMapping(value = "/fegin/dept")
public class DeptFeginController {

    @Autowired
    private DeptClientService deptClientService;


    @RequestMapping("queryList")
    public List<Dept> queryList() {
        return deptClientService.list();
    }

    @RequestMapping(value = "findById")
    public Dept findById(Integer id) {
        return deptClientService.get(id);
    }


    @RequestMapping("add")
    public Map<String, Object> add() {
        Dept dept = new Dept();
        dept.setDeptName("Rest ful API测试").setDescription("描述");
        Map<String, Object> resultMap = new HashMap<>(1);
        resultMap.put("success", deptClientService.add(dept));
        return resultMap;
    }

}
