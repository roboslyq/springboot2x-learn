package com.roboslyq.springmvc.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


/**
 *
 * 〈1、直接实现java.servlet.Filter接口
 *   2、但是这个Filter类模拟第三方提供(非Spring体系)，因此需要依赖{@link FilterRegistrationBean }来注入到Spring容器中
 *
 * 〉
 * @author luo.yongqian
 * @date 2020/3/14
 * @since 1.0.0
 */
public class FilterDemo2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.err.println("FilterDemo2 init .........");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.err.println("FilterDemo2 do .........");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.err.println("FilterDemo2 destroy .........");
    }
}
