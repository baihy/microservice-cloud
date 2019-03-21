package com.baihy.cloud.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @projectName: microservice-cloud
 * @packageName: com.baihy.cloud.rest
 * @description:
 * @author: huayang.bai
 * @date: 2019/03/21 16:30
 */
@RestController
public class ConfigRest {

    @Value("${spring.application.name}")
    private String application;

    @Value("${server.port}")
    private String port;

    @RequestMapping("/getConfig")
    public String getConfigRest() {
        return application + ";" + port;
    }

}
