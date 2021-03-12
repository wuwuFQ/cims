package com.javakc.cims.person.controller;

import com.google.gson.Gson;
import com.javakc.cims.person.entity.Person;
import com.javakc.cims.person.factory.PersonFactory;
import com.javakc.cims.person.service.PersonService;
import com.javakc.cims.util.validate.Validator;
import org.apache.ibatis.ognl.ObjectElementsAccessor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: cims
 * @description: 人员管理表现层实现类
 * @author: zhou hong gang
 * @create: 2020-11-06 11:26
 */
@WebServlet(
    name = "PersonController",
    urlPatterns = "/person.do",
    loadOnStartup = 0
)
public class PersonController extends HttpServlet {

    private PersonService personService = PersonFactory.getPersonService();
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //收集客户端操作的状态标示符
        String kc = request.getParameter("kc");
        //1.添加人员
        if(Validator.isNotEmpty(kc) && "create".equals(kc))
        {
            //1.收集参数
            String name = request.getParameter("name");
            String card = request.getParameter("card");
            String state = request.getParameter("state");
            String grade = request.getParameter("grade");
            String start = request.getParameter("start");
            String heating = request.getParameter("heating");
            String property = request.getParameter("property");
            String reason = request.getParameter("reason");
            //2.封装属性
            Person person = new Person();
            person.setName(name);
            person.setCard(card);
            if(Validator.isInteger(state))
            {
                person.setState(Integer.parseInt(state));
            }
            if(Validator.isInteger(grade))
            {
                person.setGrade(Integer.parseInt(grade));
            }
            if(Validator.isDate(start))
            {
                try {
                    person.setStart( simpleDateFormat.parse(start) );
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            if(Validator.isInteger(heating))
            {
                person.setHeating(1);
            }
            if(Validator.isInteger(property))
            {
                person.setProperty(1);
            }
            person.setReason(reason);
            //3.调用逻辑层
            personService.insert(person);
            //4.返回响应
            response.sendRedirect(request.getContextPath()+"/person.do");
        }
        //2.跳转至修改人员页面
        else if(Validator.isNotEmpty(kc) && "load".equals(kc))
        {
            String id = request.getParameter("id");
            if(Validator.isInteger(id))
            {
                request.setAttribute("entity", personService.queryById(Integer.parseInt(id)));
                request.getRequestDispatcher("/view/person/update.jsp").forward(request, response);
                return;
            }
            response.sendRedirect(request.getContextPath()+"/person.do");
        }
        //3.修改人员
        else if(Validator.isNotEmpty(kc) && "update".equals(kc))
        {
            //1.收集参数
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String card = request.getParameter("card");
            String state = request.getParameter("state");
            String grade = request.getParameter("grade");
            String start = request.getParameter("start");
            String heating = request.getParameter("heating");
            String property = request.getParameter("property");
            String reason = request.getParameter("reason");
            //2.封装属性
            Person person = new Person();
            if(Validator.isInteger(id))
            {
                person.setId(Integer.parseInt(id));
            }
            person.setName(name);
            person.setCard(card);
            if(Validator.isInteger(state)) {
                person.setState(Integer.parseInt(state));
            }
            if(Validator.isInteger(grade))
            {
                person.setGrade(Integer.parseInt(grade));
            }
            if(Validator.isDate(start))
            {
                try {
                    person.setStart( simpleDateFormat.parse(start) );
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            if(Validator.isInteger(heating))
            {
                person.setHeating(1);
            }
            if(Validator.isInteger(property))
            {
                person.setProperty(1);
            }
            person.setReason(reason);
            //3.调用逻辑层
            personService.update(person);
            //4.返回响应
            response.sendRedirect(request.getContextPath()+"/person.do");
        }
        //4.删除人员
        else if(Validator.isNotEmpty(kc) && "delete".equals(kc))
        {
            //1.收集参数
            String id = request.getParameter("id");
            if(Validator.isInteger(id))
            {
                //2.调用逻辑层
                personService.delete(Integer.parseInt(id));
            }
            //3.返回响应
            response.sendRedirect(request.getContextPath()+"/person.do");
        }
        //5.批量删除人员
        else if(Validator.isNotEmpty(kc) && "batch".equals(kc))
        {
            //1.收集参数
            String[] ids = request.getParameterValues("ids");
            if(Validator.isNotEmpty(ids))
            {
                //2.调用逻辑层
                personService.delete(ids);
            }
            //3.返回响应
            response.sendRedirect(request.getContextPath()+"/person.do");
        }
        //6.校验身份证号唯一
        else if(Validator.isNotEmpty(kc) && "card".equals(kc))
        {
            //1.收集身份证号码
            String card = request.getParameter("card");
            if(Validator.isNotEmpty(card) && card.length() == 18)
            {
                //2.查询数据库
                int count = personService.queryByCard(card);
                //3.返回JSON
                Gson gson = new Gson();
                String json = gson.toJson( Map.of("success", count == 0) );
                //4.返回响应
                PrintWriter writer = response.getWriter();
                writer.write(json);
                writer.flush();
                writer.close();
            }
        }
        else
        {
            //        1.调用逻辑层查询方法, 并写入到请求作用域中
            //        request.setAttribute("personList", personService.queryAll());
            //当前页
            int thisPage = 1;
            String thisPageParam = request.getParameter("thisPage");
            if(Validator.isInteger(thisPageParam))
            {
                thisPage = Integer.parseInt(thisPageParam);
            }
            //每页查询条数
            int pageSize = 10;
            //从多少条开始查询 1:0 2:10 3:20
            int offset = (thisPage-1)*pageSize;

            //封装动态查询参数
            Map<String, Object> params = new HashMap<>();
            params.put("offset", offset);
            params.put("size", pageSize);
            params.put("name", request.getParameter("name"));
            String state = request.getParameter("state");
            if(Validator.isInteger(state))
            {
                params.put("state", Integer.parseInt(state));
            }

            //查询总条数
            long count = personService.queryByCount(params);
            //计算最大页码
            int maxPage = (int)Math.ceil(count*1.0/pageSize);

            //1.调用逻辑层分页查询方法, 并写入到请求作用域中
            request.setAttribute("params", params);
            request.setAttribute("count", count);
            request.setAttribute("thisPage", thisPage);
            request.setAttribute("maxPage", maxPage);
            request.setAttribute("personList", personService.queryByPage(params));
            //2.跳转至人员展示页面, 通过分发器方式跳转
            request.getRequestDispatcher("/view/person/person.jsp").forward(request, response);
        }
    }

}
