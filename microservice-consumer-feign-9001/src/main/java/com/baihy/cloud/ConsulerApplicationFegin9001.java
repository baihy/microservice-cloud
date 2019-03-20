package com.baihy.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

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
@EnableFeignClients(basePackages = {"com.baihy.service"})  //开启Feign
//@EnableCircuitBreaker   // 开启服务熔断
public class ConsulerApplicationFegin9001 {

    public static void main(String[] args) {
        SpringApplication.run(ConsulerApplicationFegin9001.class, args);
    }

}
