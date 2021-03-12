package com.javakc.cims.test.util;

import com.google.gson.Gson;
import com.google.gson.internal.bind.ObjectTypeAdapter;
import com.javakc.cims.person.entity.Person;
import com.javakc.cims.subsidy.entity.Subsidy;
import com.javakc.cims.util.mybatis.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

/**
 * @program: cims
 * @description: 测试
 * @author: zhou hong gang
 * @create: 2020-11-14 11:44
 */
public class TestUtil {


    public static void main(String[] args) {
        //1.单独添加人员
        //2.选择人员添加补贴
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        Person person = new Person();
        person.setName("admin");
        sqlSession.insert("person.insert", person);
        sqlSession.commit();
        sqlSession.close();
    }








//    private static Gson gson = new Gson();
//
//    public static void main(String[] args) {
//        //1.字符串转JSON
//        String object = "{\"name\": \"admin\", \"age\": 12}";
//        Map<String, Object> map = gson.fromJson(object, Map.class);
//        System.out.println( map );
//
//        //2.JSON转字符串
//        String json = gson.toJson(map);
//        System.out.println( json );
//    }

}
