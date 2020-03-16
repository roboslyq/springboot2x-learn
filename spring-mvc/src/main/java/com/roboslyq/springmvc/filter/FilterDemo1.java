/**
 * Copyright (C), 2015-2020
 * FileName: FilterDemo1
 * Author:   luo.yongqian
 * Date:     2020/3/14 13:33
 * Description:
 * History:
 * <author>                 <time>          <version>          <desc>
 * luo.yongqian         2020/3/14 13:33      1.0.0               创建
 */
package com.roboslyq.springmvc.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 *
 * 〈
 *   1、直接实现java.servlet.Filter接口
 *   2、使用@Commponent注解注入到Spring容器中
 *   3、此Filter是全局的
 * 〉
 * @author luo.yongqian
 * @date 2020/3/14
 * @since 1.0.0
 */
@Component
public class FilterDemo1 implements Filter {

    /**
     * Filter生命周期： 初始化
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("component filter init");
    }

    /**
     *  Filter生命周期： 调用
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        ServletRequest request = servletRequest;
        ServletResponse response = servletResponse;

        System.out.println(request.getLocalAddr());
        request.setAttribute("filter1","filter1.value");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    /**
     *  Filter生命周期： 销毁
     */
    @Override
    public void destroy() {

    }
}