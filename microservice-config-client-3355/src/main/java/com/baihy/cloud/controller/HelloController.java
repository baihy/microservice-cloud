package com.baihy.cloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @projectName: microservice-cloud
 * @packageName: com.baihy.cloud.controller
 * @description:
 * @author: huayang.bai
 * @date: 2019/03/21 16:21
 */
@RestController
public class HelloController {

    

    @RequestMapping("sayHello")
    public String sayHello() {
        return "hello world";
    }

}
