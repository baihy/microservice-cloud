package com.baihy.lbrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * @ProjectName: microservice-cloud
 * @packageName: com.baihy.lbrule
 * @Description:
 * @author: huayang.bai
 * @date: 2019-03-17 09:03
 */
public class RandomRuleMySelfRule extends AbstractLoadBalancerRule {

    /***AbstractLoadBalancerRule：这个类似****/

    private int total = 0;   // 每台机器被调用的次数
    private int currentIndex = 0; // 当前机器的索引值

    // 指定调用次数，默认是5次
    private int callTimes = 5;

    public RandomRuleMySelfRule(int callTimes) {
        this.callTimes = callTimes;
    }
    public RandomRuleMySelfRule() {
    }

    /**
     *
     * 方法的作用就是根据特定的算法返回一个Server
     *
     * @param lb
     * @param key
     * @return
     */
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            // 线程被中断，则返回null，那么server对象还是null，所以会继续循环
            if (Thread.interrupted()) {
                return null;
            }
            // 通过负载均衡对象，获取可用的服务提供者
            List<Server> upList = lb.getReachableServers();
            // 通过负载均衡对象，获取所有的服务提供者
            List<Server> allList = lb.getAllServers();

            int serverCount = allList.size();
            if (serverCount == 0) {
                return null;
            }

            // 核心算法
            if (total < callTimes) {
                // 当调用次数小于5时，还是返回当前的服务器
                server = upList.get(currentIndex);
                total++;
            } else {
                total = 0;
                currentIndex++;
                if (currentIndex >= upList.size()) {
                    currentIndex = 0;
                }
            }


            if (server == null) {
                //线程终端一会
                Thread.yield();
                continue;
            }
            // 判断服务是否可用，如果可用直接返回。
            if (server.isAlive()) {
                return (server);
            }
            server = null;
            Thread.yield();
        }
        return server;

    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
        // TODO Auto-generated method stub
    }

}
