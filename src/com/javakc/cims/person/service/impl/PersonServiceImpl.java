package com.javakc.cims.person.service.impl;

import com.javakc.cims.person.entity.Person;
import com.javakc.cims.person.factory.PersonFactory;
import com.javakc.cims.person.repository.PersonRepository;
import com.javakc.cims.person.service.PersonService;

import java.util.List;
import java.util.Map;

/**
 * @program: cims
 * @description:
 * @author: zhou hong gang
 * @create: 2020-11-06 11:39
 */
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository = PersonFactory.getPersonRepository();

    @Override
    public int insert(Person entity) {
        return personRepository.insert(entity);
    }

    @Override
    public int update(Person entity) {
        return personRepository.update(entity);
    }

    @Override
    public int delete(int id) {
        return personRepository.delete(id);
    }

    @Override
    public int delete(String[] ids) {
        int[] array = new int[ids.length];
        for (int i = 0; i < ids.length; i++) {
            array[i] = Integer.parseInt(ids[i]);
        }
        return personRepository.delete(array);
    }

    @Override
    public List<Person> queryAll() {
        return personRepository.queryAll();
    }

    @Override
    public List<Person> queryByPage(Map<String, Object> params) {
        return personRepository.queryByPage(params);
    }

    @Override
    public long queryByCount(Map<String, Object> params) {
        return personRepository.queryByCount(params);
    }

    @Override
    public Person queryById(int id) {
        return personRepository.queryById(id);
    }

    @Override
    public int queryByCard(String card) {
        return personRepository.queryByCard(card);
    }

}
