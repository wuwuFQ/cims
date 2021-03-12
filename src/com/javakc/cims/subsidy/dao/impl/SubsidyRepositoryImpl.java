package com.javakc.cims.subsidy.dao.impl;

import com.javakc.cims.subsidy.dao.SubsidyRepository;
import com.javakc.cims.subsidy.entity.Subsidy;
import com.javakc.cims.util.mybatis.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

/**
 * @program: cims
 * @description:
 * @author: zhou hong gang
 * @create: 2020-11-06 11:39
 */
public class SubsidyRepositoryImpl implements SubsidyRepository {

    @Override
    public int insert(Subsidy entity) {
        SqlSession sqlSession = MybatisUtils.openSqlSession();
        int result = sqlSession.insert("subsidy.insert", entity);
        sqlSession.close();
        return result;
    }

    @Override
    public int update(Subsidy entity) {
        SqlSession sqlSession = MybatisUtils.openSqlSession();
        int result = sqlSession.update("subsidy.update", entity);
        sqlSession.close();
        return result;
    }

    @Override
    public int delete(int id) {
        SqlSession sqlSession = MybatisUtils.openSqlSession();
        int result = sqlSession.delete("subsidy.delete", id);
        sqlSession.close();
        return result;
    }

    @Override
    public int delete(int[] ids) {
        SqlSession sqlSession = MybatisUtils.openSqlSession();
        int result = sqlSession.delete("subsidy.batch", ids);
        sqlSession.close();
        return result;
    }

    @Override
    public List<Subsidy> queryAll() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        List<Subsidy> list = sqlSession.selectList("subsidy.queryAll");
        sqlSession.close();
        return list;
    }

    @Override
    public List<Subsidy> queryByPage(Map<String, Object> params) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        List<Subsidy> list = sqlSession.selectList("subsidy.queryByPage", params);
        sqlSession.close();
        return list;
    }

    @Override
    public long queryByCount(Map<String, Object> params) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        long count = sqlSession.selectOne("subsidy.queryByCount", params);
        sqlSession.close();
        return count;
    }

    @Override
    public Subsidy queryById(int id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        Subsidy Subsidy = sqlSession.selectOne("subsidy.queryById", id);
        sqlSession.close();
        return Subsidy;
    }

    @Override
    public List<Map<String, Object>> querySubsidyPerson(int type) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        List<Map<String, Object>> list = sqlSession.selectList("subsidy.querySubsidyPerson", Map.of("type", type));
        sqlSession.close();
        return list;
    }

}
