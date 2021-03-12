package com.javakc.cims.test.controller;

import com.javakc.cims.test.entity.Test;
import com.javakc.cims.test.factory.TestFactory;
import com.javakc.cims.test.service.TestService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: cims
 * @description: 测试模块表现层实现类
 * @author: zhou hong gang
 * @create: 2020-11-05 16:08
 */
@WebServlet(
    name = "TestController",
    urlPatterns = "/test.do",
    loadOnStartup = 0
)
public class TestController extends HttpServlet {

    private TestService testService = TestFactory.getTestService();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        testService.insert(null);

        List<Test> list = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            Test entity = new Test();
            entity.setId(i);
            entity.setName("柴涛"+i);
            entity.setAge(i);
            entity.setBirthday(new Date());

            list.add(entity);
        }

        request.setAttribute("list", list);

        //1.分发器 2.重定向
        request.getRequestDispatcher("/success.jsp").forward(request, response);
    }

}
