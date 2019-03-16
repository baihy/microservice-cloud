package com.baihy.lbrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;

/**
 * @ProjectName: microservice-cloud
 * @packageName: com.baihy.lbrule
 * @Description: Ribbon客户端负载均衡，自定义负载均衡策略类
 * @author: huayang.bai
 * @date: 2019-03-16 20:11
 */
public class MySelfLBRule {

    @Bean
    public IRule mySelfRule() {
        return new RandomRule();
    }

}
