package com.javakc.cims.test.service;

import com.javakc.cims.test.entity.Test;

import java.util.List;
import java.util.Map;

/**
 * @program: cims
 * @description: 测试模块逻辑层接口
 * @author: zhou hong gang
 * @create: 2020-11-05 15:45
 */
public interface TestService {
    /**
     * 添加测试数据
     * @param entity 实体
     * @return 成功/失败
     */
    public int insert(Test entity);

    /**
     * 修改测试数据
     * @param entity 实体
     * @return 成功/失败
     */
    public int update(Test entity);

    /**
     * 删除测试数据
     * @param id 主键
     * @return 成功/失败
     */
    public int delete(int id);

    /**
     * 查询全部数据
     * @return 测试数据集合
     */
    @Deprecated
    public List<Test> queryAll();

    /**
     * 根据条件分页查询
     * @param params 查询条件
     * @return 符合条件结果集
     */
    public List<Test> queryByPage(Map<String, Object> params);

    /**
     * 根据条件查询总条数
     * @param params 查询条件
     * @return 符合条件总条数
     */
    public long queryByCount(Map<String, Object> params);

    /**
     * 根据主键查询单条记录
     * @param id 主键
     * @return 单条记录
     */
    public Test queryById(int id);
}
