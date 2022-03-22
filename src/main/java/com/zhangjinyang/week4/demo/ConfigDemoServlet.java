package com.zhangjinyang.week4.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="Config", value="/config",
        initParams = {
                @WebInitParam(name="name", value="zhangjinyang"),
                @WebInitParam(name="studentId", value="2020211001001310")
        } )
public class ConfigDemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = getServletConfig().getInitParameter("name");
        String id = getServletConfig().getInitParameter("studentId");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("name : " + name + "<br>");
        out.print("studentid : " + id);
    }
}
