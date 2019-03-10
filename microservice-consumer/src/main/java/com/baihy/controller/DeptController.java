package com.baihy.controller;

import com.baihy.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName: microservice-cloud
 * @packageName: com.baihy.controller
 * @Description:
 * @author: huayang.bai
 * @date: 2019-03-09 17:50
 */
@RestController
@RequestMapping(value = "consumer/dept")
public class DeptController {

    private String baseUrl = "http://127.0.0.1:8001";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("queryList")
    public List<Dept> queryList() {
        return restTemplate.getForObject(this.baseUrl + "/dept/queryList", List.class);
    }

    @RequestMapping("findById")
    public Dept findById() {
        return restTemplate.getForObject(baseUrl + "/dept/findById?id=1", Dept.class);
    }


    @RequestMapping("add")
    public Map<String, Object> add() {
        Dept dept = new Dept();
        dept.setDeptName("Rest ful API测试").setDescription("描述");
        return restTemplate.postForObject(baseUrl + "/dept/add", dept, Map.class);
    }

}
