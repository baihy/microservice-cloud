package com.baihy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ProjectName: microservice-cloud
 * @packageName: com.baihy
 * @Description:
 * @author: huayang.bai
 * @date: 2019-03-09 18:36
 */
@SpringBootApplication
@EnableEurekaClient   // 开启eureka客户端服务
@EnableDiscoveryClient
public class ConsulerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsulerApplication.class, args);
    }

}
