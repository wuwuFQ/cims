package com.javakc.cims.person.service;


import com.javakc.cims.person.entity.Person;

import java.util.List;
import java.util.Map;

/**
 * @program: cims
 * @description: 人员模块数据层接口
 * @author: zhou hong gang
 * @create: 2020-11-05 15:45
 */
public interface PersonService {
    /**
     * 添加人员数据
     * @param entity 实体
     * @return 成功/失败
     */
    public int insert(Person entity);

    /**
     * 修改人员数据
     * @param entity 实体
     * @return 成功/失败
     */
    public int update(Person entity);

    /**
     * 删除人员数据
     * @param id 主键
     * @return 成功/失败
     */
    public int delete(int id);
    public int delete(String[] ids);

    /**
     * 查询全部数据
     * @return 人员数据集合
     */
    @Deprecated
    public List<Person> queryAll();

    /**
     * 根据条件分页查询
     * @param params 查询条件
     * @return 符合条件结果集
     */
    public List<Person> queryByPage(Map<String, Object> params);

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
    public Person queryById(int id);

    /**
     * 根据证件编号查询唯一性
     * @param card 证件编号
     * @return 0/1
     */
    public int queryByCard(String card);
}
