package com.javakc.cims.subsidy.controller;

import com.javakc.cims.subsidy.factory.SubsidyFactory;
import com.javakc.cims.subsidy.service.SubsidyService;
import com.javakc.cims.util.validate.Validator;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@WebServlet(
    name = "SubsidyController",
    urlPatterns = "/subsidy.do",
    loadOnStartup = 0
)
public class SubsidyController extends HttpServlet {

    private SubsidyService subsidyService = SubsidyFactory.getSubsidyService();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1:供暖 2：物业
        String kc = request.getParameter("kc");
        String type = request.getParameter("type");
        //查询补贴的人员
        if(Validator.isNotEmpty(kc) && "subsidyPerson".equals(kc))
        {
            List<Map<String, Object>> list = subsidyService.querySubsidyPerson(Integer.parseInt(type));
            /**
             * JSON
             * json array
             *  [
             *     {"id": 1, "name": "admin1", "card": "12345678", "state": 1},
             *     {"id": 1, "name": "admin1", "card": "12345678", "state": 1}
             *  ]
             * json object
             *  {"id": 1, "name": "admin1", "card": "12345678", "state": 1}
             */

            StringBuilder builder = new StringBuilder("[");
            for (int i = 0; i < list.size(); i++) {
                Map<String, Object> data = list.get(i);
                builder.append("{\"id\": "+data.get("id")+", \"name\": \""+data.get("name")+"\", \"card\": \""+data.get("card")+"\", \"state\": "+data.get("state")+"}");
                if(i != list.size() -1)
                {
                    builder.append(",");
                }
            }
            builder.append("]");

            response.setContentType("application/json;charset=UTF8");
            PrintWriter writer = response.getWriter();
            writer.write(builder.toString());
            writer.flush();
            writer.close();
        }
        else
        {
            //2.查询数据库
            request.setAttribute("type", type);
            request.setAttribute("list", subsidyService.queryByPage(Map.of("type", type)));
            //3.返回动态响应
            request.getRequestDispatcher("/view/subsidy/subsidy.jsp").forward(request, response);
        }
    }

}
