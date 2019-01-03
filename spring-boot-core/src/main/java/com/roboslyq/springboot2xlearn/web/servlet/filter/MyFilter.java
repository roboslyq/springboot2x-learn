package com.roboslyq.springboot2xlearn.web.servlet.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author roboslyq
 * @data 2018/12/30 0:19
 * @desc :
 **/
@WebFilter(filterName = "myFilter" , urlPatterns ="/*")
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("start init---->");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("do filter---->");
        filterChain.doFilter( servletRequest,servletResponse );
//        PrintWriter pw = servletResponse.getWriter();
//        pw.write("roboslyq");
//        pw.close();
    }

    @Override
    public void destroy() {
        System.out.println("destroy---->");

    }
}
