package com.javakc.cims.test.factory;

import com.javakc.cims.test.repository.TestRepository;
import com.javakc.cims.test.repository.impl.TestRepositoryImpl;
import com.javakc.cims.test.service.TestService;
import com.javakc.cims.test.service.impl.TestServiceImpl;

/**
 * @program: cims
 * @description: 测试模块工厂类
 * @author: zhou hong gang
 * @create: 2020-11-05 16:06
 */
public class TestFactory {

    /**
     * 获取测试模块逻辑层实现类
     * @return 逻辑层实现类
     */
    public static TestService getTestService()
    {
        return new TestServiceImpl();
    }

    /**
     * 获取测试模块数据层实现类
     * @return 数据层实现类
     */
    public static TestRepository getTestRepository()
    {
        return new TestRepositoryImpl();
    }

}
