package com.javakc.cims.util.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/**
 * @program: web01
 * @description: 中文编码过滤器
 * @author: zhou hong gang
 * @create: 2020-11-02 11:28
 */
@WebFilter(
    filterName = "CharacterEncodingFilter",
    urlPatterns = "*.do",
    initParams = {
        @WebInitParam(
            name = "encoding",
            value = "UTF-8"
        )
    }
)
public class CharacterEncodingFilter implements Filter {

    private String encoding;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encoding = filterConfig.getInitParameter("encoding");
        if(null == encoding || "".equals(encoding))
        {
            encoding = "UTF-8";
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding(encoding);
        filterChain.doFilter(servletRequest, servletResponse);
    }

}
