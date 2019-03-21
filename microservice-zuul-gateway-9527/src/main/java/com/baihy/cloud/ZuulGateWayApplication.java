package com.baihy.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @projectName: microservice-cloud
 * @packageName: com.baihy.cloud
 * @description:
 * @author: huayang.bai
 * @date: 2019/03/21 9:39
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulGateWayApplication {

    public static void main(String[] args){

        SpringApplication.run(ZuulGateWayApplication.class, args);

    }

}
