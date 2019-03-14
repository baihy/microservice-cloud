package com.baihy.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @projectName: microservice-cloud
 * @packageName: com.baihy.eureka
 * @description:
 * @author: huayang.bai
 * @date: 2019/03/14 14:13
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication7003 {


    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication7003.class, args);
    }

}
