package com.javakc.cims.subsidy.service.impl;

import com.javakc.cims.subsidy.dao.SubsidyRepository;
import com.javakc.cims.subsidy.entity.Subsidy;
import com.javakc.cims.subsidy.factory.SubsidyFactory;
import com.javakc.cims.subsidy.service.SubsidyService;

import java.util.List;
import java.util.Map;

/**
 * @program: cims
 * @description:
 * @author: zhou hong gang
 * @create: 2020-11-10 09:16
 */
public class SubsidyServiceImpl implements SubsidyService {

    private SubsidyRepository subsidyRepository = SubsidyFactory.getSubsidyRepository();

    @Override
    public int insert(Subsidy entity) {
        return 0;
    }

    @Override
    public int update(Subsidy entity) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public int delete(int[] ids) {
        return 0;
    }

    @Override
    public List<Subsidy> queryAll() {
        return null;
    }

    @Override
    public List<Subsidy> queryByPage(Map<String, Object> params) {
        return subsidyRepository.queryByPage(params);
    }

    @Override
    public long queryByCount(Map<String, Object> params) {
        return 0;
    }

    @Override
    public Subsidy queryById(int id) {
        return null;
    }

    @Override
    public List<Map<String, Object>> querySubsidyPerson(int type) {
        return subsidyRepository.querySubsidyPerson(type);
    }
}
