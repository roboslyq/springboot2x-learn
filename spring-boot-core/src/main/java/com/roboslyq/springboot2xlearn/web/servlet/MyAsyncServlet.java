package com.roboslyq.springboot2xlearn.web.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author roboslyq
 * @data 2018/12/30 0:45
 * @desc :
 **/
@WebServlet(urlPatterns = "/my/asyncServlet",asyncSupported = true)
public class MyAsyncServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AsyncContext asyncContext = req.startAsync();
        asyncContext.start( new Runnable() {
            @Override
            public void run() {
                try {
                    resp.getWriter().print( "helloword---asyncServlet" );
                    asyncContext.complete();

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        } );
    }
}
