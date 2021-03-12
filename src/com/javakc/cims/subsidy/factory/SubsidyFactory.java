package com.javakc.cims.subsidy.factory;


import com.javakc.cims.subsidy.dao.SubsidyRepository;
import com.javakc.cims.subsidy.dao.impl.SubsidyRepositoryImpl;
import com.javakc.cims.subsidy.service.SubsidyService;
import com.javakc.cims.subsidy.service.impl.SubsidyServiceImpl;

/**
 * @program: cims
 * @description: 补贴模块工厂类
 * @author: zhou hong gang
 * @create: 2020-11-05 16:06
 */
public class SubsidyFactory {

    /**
     * 获取补贴模块逻辑层实现类
     * @return 逻辑层实现类
     */
    public static SubsidyService getSubsidyService()
    {
        return new SubsidyServiceImpl();
    }

    /**
     * 获取补贴模块数据层实现类
     * @return 数据层实现类
     */
    public static SubsidyRepository getSubsidyRepository()
    {
        return new SubsidyRepositoryImpl();
    }

}
