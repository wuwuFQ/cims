package com.javakc.cims.util.cache;

import org.apache.ibatis.cache.Cache;

import java.util.concurrent.locks.ReadWriteLock;

/**
 * @program: cims
 * @description: mybatis二级缓存
 * @author: zhou hong gang
 * @create: 2020-11-19 11:44
 */
public class MybatisCache implements Cache {

    private String id;

    public MybatisCache(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    /**
     * 从数据库查询后传入查询结果
     * @param o key
     * @param o1 value
     */
    @Override
    public void putObject(Object o, Object o1) {
        System.out.println("存放数据 key:"+o);
        System.out.println("存放数据 value:"+o1);
    }

    /**
     * 一级缓存没有则调用该方法
     * @param o key
     * @return value
     */
    @Override
    public Object getObject(Object o) {
        System.out.println("获取数据 key:"+o);
        return null;
    }

    @Override
    public Object removeObject(Object o) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return null;
    }

}
