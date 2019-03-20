package com.baihy.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @projectName: microservice-cloud
 * @packageName: com.baihy.cloud
 * @description:
 * @author: huayang.bai
 * @date: 2019/03/20 15:51
 */
@SpringBootApplication
@EnableHystrixDashboard // 开启Hystrix Dashboard监控
public class HystrixDashboard8080 {

    public static void main(String[] args) {

        SpringApplication.run(HystrixDashboard8080.class, args);

    }

}
