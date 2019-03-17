package com.baihy.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @projectName: microservice-cloud
 * @packageName: com.baihy.cloud.controller
 * @description:
 * @author: huayang.bai
 * @date: 2019/03/12 15:22
 */
@RestController
public class DiscoveryController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "deptDiscoveryClient", method = RequestMethod.GET)
    public DiscoveryClient discoveryClient() {
        /*********以下代码可选***********/
        List<String> services = discoveryClient.getServices();
        //  获取所有的微服务名称
        List<ServiceInstance> instances = discoveryClient.getInstances("microservice-provider-dept");
        // 通过服务名称获取所有的微服务实例
        System.out.println(instances);
        System.out.println(services);
        return discoveryClient;
    }

}
