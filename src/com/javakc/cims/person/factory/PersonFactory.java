package com.javakc.cims.person.factory;

import com.javakc.cims.person.repository.PersonRepository;
import com.javakc.cims.person.repository.impl.PersonRepositoryImpl;
import com.javakc.cims.person.service.PersonService;
import com.javakc.cims.person.service.impl.PersonServiceImpl;

/**
 * @program: cims
 * @description: 人员模块工厂类
 * @author: zhou hong gang
 * @create: 2020-11-05 16:06
 */
public class PersonFactory {

    /**
     * 获取人员模块逻辑层实现类
     * @return 逻辑层实现类
     */
    public static PersonService getPersonService()
    {
        return new PersonServiceImpl();
    }

    /**
     * 获取人员模块数据层实现类
     * @return 数据层实现类
     */
    public static PersonRepository getPersonRepository()
    {
        return new PersonRepositoryImpl();
    }

}
