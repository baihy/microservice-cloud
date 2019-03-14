package com.baihy.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @projectName: microservice-cloud
 * @packageName: PACKAGE_NAME
 * @description:
 * @author: huayang.bai
 * @date: 2019/03/14 14:07
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication7002 {


    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication7002.class, args);
    }

}
