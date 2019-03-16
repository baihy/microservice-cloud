package com.baihy.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ProjectName: microservice-cloud
 * @packageName: com.baihy
 * @Description:
 * @author: huayang.bai
 * @date: 2019-03-09 17:50
 */
@Configuration
public class BeanConfig {

    @Bean
    @LoadBalanced  // spring cloude 基于Netfilx Ribbon实现的一套客户端负载均衡的工具
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public IRule myRule() {
        /******指定负载均衡的策略********/
        // return new RandomRule(); // 随机策略
        RetryRule rule = new RetryRule();
        rule.setMaxRetryMillis(2); // 设置重试次数
        return rule;
    }


}
