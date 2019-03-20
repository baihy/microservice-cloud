package com.baihy.cloud.fallback;

import com.baihy.entity.Dept;
import com.baihy.service.DeptClientService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @projectName: microservice-cloud
 * @packageName: com.baihy.service
 * @description: 负责处理出现异常的时候，会处理异常。
 * @author: huayang.bai
 * @date: 2019/03/20 10:51
 */
@Component // 特别注意：这个实现了FallbackFactory接口的类，一定要交个spring来管理
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {

    public DeptClientServiceFallbackFactory() {
        System.out.println("**************************DeptClientServiceFallbackFactory创建对象***********************************");
    }

    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public boolean add(Dept dept) {
                return false;
            }

            @Override
            public Dept get(Integer id) {
                return new Dept().setId(id).setDeptName("该主键id " + id + "数据不存在！提供者服务已经关闭").setHost("8004");
            }

            @Override
            public List<Dept> list() {
                return null;
            }
        };
    }
}
