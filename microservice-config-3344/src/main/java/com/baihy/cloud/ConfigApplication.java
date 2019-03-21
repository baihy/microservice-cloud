package com.baihy.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @projectName: microservice-cloud
 * @packageName: com.baihy.cloud
 * @description:
 * @author: huayang.bai
 * @date: 2019/03/21 14:40
 */
@SpringBootApplication
@EnableConfigServer   // 配置spring cloud config的
public class ConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication.class, args);
    }
}
