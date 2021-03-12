package com.javakc.cims.test.service.impl;

import com.javakc.cims.test.entity.Test;
import com.javakc.cims.test.factory.TestFactory;
import com.javakc.cims.test.repository.TestRepository;
import com.javakc.cims.test.service.TestService;

import java.util.List;
import java.util.Map;

/**
 * @program: cims
 * @description: 测试模块逻辑层实现类
 * @author: zhou hong gang
 * @create: 2020-11-05 16:06
 */
public class TestServiceImpl implements TestService {

    private TestRepository testRepository = TestFactory.getTestRepository();

    @Override
    public int insert(Test entity) {
        return testRepository.insert(entity);
    }

    @Override
    public int update(Test entity) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public List<Test> queryAll() {
        return null;
    }

    @Override
    public List<Test> queryByPage(Map<String, Object> params) {
        return null;
    }

    @Override
    public long queryByCount(Map<String, Object> params) {
        return 0;
    }

    @Override
    public Test queryById(int id) {
        return null;
    }

}
