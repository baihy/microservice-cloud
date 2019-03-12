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
@EnableEurekaClient
@EnableDiscoveryClient
public class MicroserviceConsulerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceConsulerApplication.class, args);
    }

}
