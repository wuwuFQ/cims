package com.javakc.cims.person.repository.impl;

import com.javakc.cims.person.entity.Person;
import com.javakc.cims.person.repository.PersonRepository;
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
public class PersonRepositoryImpl implements PersonRepository {

    @Override
    public int insert(Person entity) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        int result = 0;
        try
        {
            result = sqlSession.insert("person.insert", entity);
            sqlSession.commit();
        }
        catch(Exception e)
        {
            sqlSession.rollback();
        }
        finally {
            sqlSession.close();
        }
        return result;
    }

    @Override
    public int update(Person entity) {
        SqlSession sqlSession = MybatisUtils.openSqlSession();
        int result = sqlSession.update("person.update", entity);
        sqlSession.close();
        return result;
    }

    @Override
    public int delete(int id) {
        SqlSession sqlSession = MybatisUtils.openSqlSession();
        int result = sqlSession.delete("person.delete", id);
        sqlSession.close();
        return result;
    }

    @Override
    public int delete(int[] ids) {
        SqlSession sqlSession = MybatisUtils.openSqlSession();
        int result = sqlSession.delete("person.batch", ids);
        sqlSession.close();
        return result;
    }

    @Override
    public List<Person> queryAll() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        List<Person> list = sqlSession.selectList("person.queryAll");
        sqlSession.close();
        return list;
    }

    @Override
    public List<Person> queryByPage(Map<String, Object> params) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        List<Person> list = sqlSession.selectList("person.queryByPage", params);
        sqlSession.close();
        return list;
    }

//    一级缓存
//    key: person.queryByPage + params
//    value: list

//    二级缓存
//    1.开启二级缓存
//    2.配置映射缓存


    @Override
    public long queryByCount(Map<String, Object> params) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        long count = sqlSession.selectOne("person.queryByCount", params);
        sqlSession.close();
        return count;
    }

    @Override
    public Person queryById(int id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        Person person = sqlSession.selectOne("person.queryById", id);
        sqlSession.close();
        return person;
    }

    @Override
    public int queryByCard(String card) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        int count = sqlSession.selectOne("person.queryByCard", card);
        sqlSession.close();
        return count;
    }

}
