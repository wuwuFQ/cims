package com.javakc.cims.subsidy.service;

import com.javakc.cims.subsidy.entity.Subsidy;

import java.util.List;
import java.util.Map;

/**
 * @program: cims
 * @description: 补贴模块数据层接口
 * @author: zhou hong gang
 * @create: 2020-11-10 10:04
 */
public interface SubsidyService {
    /**
     * 添加补贴数据
     * @param entity 实体
     * @return 成功/失败
     */
    public int insert(Subsidy entity);

    /**
     * 修改补贴数据
     * @param entity 实体
     * @return 成功/失败
     */
    public int update(Subsidy entity);

    /**
     * 删除补贴数据
     * @param id 主键
     * @return 成功/失败
     */
    public int delete(int id);
    public int delete(int[] ids);

    /**
     * 查询全部数据
     * @return 补贴数据集合
     */
    @Deprecated
    public List<Subsidy> queryAll();

    /**
     * 根据条件分页查询
     * @param params 查询条件
     * @return 符合条件结果集
     */
    public List<Subsidy> queryByPage(Map<String, Object> params);

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
    public Subsidy queryById(int id);

    /**
     * 根据类型查询需要补贴的人员
     * @param type 类型 1供暖 2物业
     * @return 补贴结果集
     */
    public List<Map<String, Object>> querySubsidyPerson(int type);
}
