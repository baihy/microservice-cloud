package com.baihy.service;

import com.baihy.cloud.fallback.DeptClientServiceFallbackFactory;
import com.baihy.entity.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @ProjectName: microservice-cloud
 * @packageName: com.baihy.service
 * @Description:
 * @author: huayang.bai
 * @date: 2019-03-17 11:17
 */
@FeignClient(value = "microservice-provider-dept", fallbackFactory = DeptClientServiceFallbackFactory.class)
// 指定调用微服务中服务的提供者的名字。
public interface DeptClientService {
    /***特别注意：这里指定的请求地址一定要和Controller中的请求地址保持一致**/

    @RequestMapping("/dept/add")
    boolean add(Dept dept);

    @RequestMapping(value = "/dept/findById")
    Dept get(@RequestParam("id") Integer id);

    @RequestMapping("/dept/queryList")
    List<Dept> list();

}

