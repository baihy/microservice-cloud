package com.baihy.cloud.controller;

import com.baihy.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
@RequestMapping(value = "dept")
public class DeptController {

    // 通过原生的url地址来访问REST ful API接口
    //private String REST_URL_PREFIX = "http://127.0.0.1:8001";


    // 通过微服务中服务的提供者名字，来访问。这才是真正的微服务调用
    private String REST_URL_PREFIX = "http://microservice-provider-dept";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("queryList")
    public List<Dept> queryList() {
        return restTemplate.getForObject(this.REST_URL_PREFIX + "/dept/queryList", List.class);
    }

    @RequestMapping("findById")
    public Dept findById() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/findById?id=1", Dept.class);
    }


    @RequestMapping("add")
    public Map<String, Object> add() {
        Dept dept = new Dept();
        dept.setDeptName("Rest ful API测试").setDescription("描述");
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Map.class);
    }

}
