package com.zhangjinyang.week3.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String Username = request.getParameter("Username");
        String password = request.getParameter("password");
        String Email = request.getParameter("Email");
        String gender = request.getParameter("gender");
        String Birthdate = request.getParameter("Birthdate");

        PrintWriter writer = response.getWriter();

        writer.println("<br>Username"+Username);
        writer.println("<br>password"+password);
        writer.println("<br>Email"+Email);
        writer.println("<br>gender"+gender);
        writer.println("<br>Birthdate"+Birthdate);
        writer.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
