package com.javakc.cims.test.repository.impl;

import com.javakc.cims.test.entity.Test;
import com.javakc.cims.test.repository.TestRepository;
import com.javakc.cims.util.mybatis.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

/**
 * @program: cims
 * @description: 测试模块数据层实现类
 * @author: zhou hong gang
 * @create: 2020-11-05 16:02
 */
public class TestRepositoryImpl implements TestRepository {

    @Override
    public int insert(Test entity) {
        System.out.println("执行数据库操作");
        return 0;
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
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        List<Test> list = sqlSession.selectList("test.queryAll");
        sqlSession.close();
        return list;
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
