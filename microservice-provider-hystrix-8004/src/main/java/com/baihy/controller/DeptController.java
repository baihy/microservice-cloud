package com.baihy.controller;

import com.baihy.entity.Dept;
import com.baihy.service.IDeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ProjectName: microservice-cloud
 * @packageName: com.baihy.cloud.controller
 * @Description:
 * @author: huayang.bai
 * @date: 2019-03-09 17:19
 */
@RestController
@RequestMapping("/dept")
public class DeptController {


    @Autowired
    private IDeptService deptService;

    @RequestMapping(value = "queryList", method = {RequestMethod.GET})
    public List<Dept> queryList() {
        return deptService.list().parallelStream().map(dept -> dept.setHost("8001")).collect(Collectors.toList());
    }

    @RequestMapping(value = "add", method = {RequestMethod.POST})
    public Map<String, Object> add(@RequestBody Dept dept) {
        Map<String, Object> resultMap = new HashMap<>(2);
        if (this.deptService.add(dept)) {
            resultMap.put("success", true);
            resultMap.put("msg", "保存成功");
        } else {
            resultMap.put("success", false);
            resultMap.put("msg", "保存失败");
        }
        return resultMap;
    }


    @RequestMapping(value = "findById", method = {RequestMethod.GET})
    @HystrixCommand(fallbackMethod = "processHystrix_FindById") // 一旦调用发生异常，就会自动调用fallbackMethod属性指定的方法
    public Dept findById(Integer id) {
        Dept dept = deptService.get(id);
        if (dept == null) {
            throw new RuntimeException("主键ID" + id + "不存在");
        }
        return dept;
    }


    public Dept processHystrix_FindById(Integer id) {
        return new Dept().setId(id).setDeptName("该主键id " + id + "数据不存在！").setHost("8004");
    }

}
