package com.baihy.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ProjectName: microservice-cloud
 * @packageName: com.baihy.eureka
 * @Description:
 * @author: huayang.bai
 * @date: 2019-03-10 11:42
 */
@SpringBootApplication
@EnableEurekaServer
// Eureka Server服务器启动类，接收其他服务注册进来
public class MicroServiceEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceEurekaApplication.class, args);
    }

}
