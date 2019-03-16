package com.baihy.cloud;

import com.baihy.lbrule.MySelfLBRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

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
@RibbonClient(name = "microservice-provider-dept", configuration = MySelfLBRule.class)
// 通过@RibbonClient注解为指定的服务，指定自定义的负载均衡策略配置类
public class ConsulerApplication9000 {

    public static void main(String[] args) {
        SpringApplication.run(ConsulerApplication9000.class, args);
    }

}
