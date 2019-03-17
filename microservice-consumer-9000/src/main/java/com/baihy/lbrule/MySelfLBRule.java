package com.baihy.lbrule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;

/**
 * @ProjectName: microservice-cloud
 * @packageName: com.baihy.lbrule
 * @Description: Ribbon客户端负载均衡，自定义负载均衡策略类
 * @author: huayang.bai
 * @date: 2019-03-16 20:11
 */
public class MySelfLBRule {
    /***注意这个类是不能被扫描到的***/
    @Bean
    public IRule mySelfRule() {
        return new RandomRuleMySelfRule(3);
    }

}
