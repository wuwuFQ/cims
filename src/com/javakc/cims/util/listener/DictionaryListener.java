package com.javakc.cims.util.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Map;

/**
 * @program: cims
 * @description: 数据字典监听器
 * @author: zhou hong gang
 * @create: 2020-11-09 10:42
 */
@WebListener
public class DictionaryListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //1.获取servlet context对象
        ServletContext context = sce.getServletContext();
        //2.初始化数据字典相关内容
        Map<String, String> grade = Map.of("8", "科级副职", "7", "科级正职", "6", "处级副职" ,
                "5", "处级正职", "4", "司级副职", "3", "司级正职", "2", "部级副职", "1", "部级正职");
        context.setAttribute("grade", grade);
    }

}
