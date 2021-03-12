package com.javakc.cims.util.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @program: cims
 * @description: mybatis工具类, 负责提供SqlSession接口
 * @author: zhou hong gang
 * @create: 2020-11-06 10:54
 */
public class MybatisUtils {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            //1.读取mybatis配置文件
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            //2.构建SqlSessionFactory
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取SqlSession
     * @return SqlSession
     */
    public static SqlSession getSqlSession()
    {
        return sqlSessionFactory.openSession();
    }

    /**
     * 获取SqlSession
     * @return SqlSession
     */
    public static SqlSession openSqlSession()
    {
        return sqlSessionFactory.openSession(true);
    }

}
