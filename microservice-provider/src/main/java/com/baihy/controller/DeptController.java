package com.baihy.controller;

import com.baihy.entity.Dept;
import com.baihy.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: microservice-cloud
 * @packageName: com.baihy.controller
 * @Description:
 * @author: huayang.bai
 * @date: 2019-03-09 17:19
 */
@RestController
@RequestMapping("dept")
public class DeptController {


    @Autowired
    private IDeptService deptService;

    @RequestMapping(value = "queryList", method = {RequestMethod.GET})
    public List<Dept> queryList() {
        return deptService.list();
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
    public Dept findById(Integer id) {
        return deptService.get(id);
    }

}
