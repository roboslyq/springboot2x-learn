/**
 * Copyright (C), 2015-2020
 * FileName: InterceptorDemo1
 * Author:   luo.yongqian
 * Date:     2020/3/14 17:13
 * Description:
 * History:
 * <author>                 <time>          <version>          <desc>
 * luo.yongqian         2020/3/14 17:13      1.0.0               创建
 */
package com.roboslyq.springmvc.interceptor;

/**
 *
 * 〈〉
 * @author luo.yongqian
 * @date 2020/3/14
 * @since 1.0.0
 */

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InterceptorDemo2 extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println(" prehandler interceptor 2...");
      return super.preHandle(request,response,handler);
    }

    /**
     * This implementation is empty.
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println(" postHandler interceptor 2...");
        super.postHandle(request,response,handler,modelAndView);

    }

    /**
     * This implementation is empty.
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                @Nullable Exception ex) throws Exception {
        System.out.println(" afterCompletion interceptor 2...");
        super.afterCompletion(request,response,handler,ex);
    }



}