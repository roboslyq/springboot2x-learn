package com.roboslyq.springboot2xlearn.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author roboslyq
 * @data 2018/12/29 23:59
 * @desc :
 **/
@WebServlet(urlPatterns = "/my/servlet")
public class MyServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().print( "helloword" );
    }
}