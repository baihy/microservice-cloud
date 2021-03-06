package com.baihy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ProjectName: microservice-cloud
 * @packageName: com.baihy
 * @Description:
 * @author: huayang.bai
 * @date: 2019-03-09 17:22
 */
@SpringBootApplication
@EnableEurekaClient // 标识这个服务是需要注册到eureka server的列表中
@EnableDiscoveryClient // 开启服务发现注解
@EnableCircuitBreaker // 开启熔断器
public class ProviderApplicationHystrix8004 {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplicationHystrix8004.class, args);
    }

}
