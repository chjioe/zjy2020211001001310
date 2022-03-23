package com.zhangjinyang.week3.demo;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "RegisterServlet",urlPatterns = {"/register"},loadOnStartup = 1)
public class RegisterServlet extends HttpServlet {
    Connection conn = null;
    PreparedStatement psm = null;
    ResultSet rst = null;
    public void init() throws ServletException {
        ServletContext context = getServletConfig().getServletContext();
        String driver = context.getInitParameter("driver");
        String url = context.getInitParameter("url");
        String username = context.getInitParameter("Username");
        String password = context.getInitParameter("Password");


        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String Username = request.getParameter("Username");
        String password = request.getParameter("password");
        String Email = request.getParameter("Email");
        String gender = request.getParameter("gender");
        String Birthdate = request.getParameter("Birthdate");

        PrintWriter writer = response.getWriter();
        writer.print("<!DOCTYPE html>");
        writer.print("<html>");
        writer.print("<head>");
        writer.print("<meta charset='UTF-8'>");
        writer.print("<title>UserTable</title>");

        writer.print("</head>");
        writer.print("<body>");
        writer.print("<h1 align='center'>UserTable</h1>");
        writer.print(" <hr>");
        writer.print("<table border='2px' align='center' width='60%'>");
        writer.print("<tr>");
        writer.print("<th>ID</th>");
        writer.print("<th>UserName</th>");
        writer.print("<th>Password</th>");
        writer.print("<th>Email</th>");
        writer.print("<th>Gender</th>");
        writer.print("<th>Birthdate</th>");
        writer.print("</tr>");

        try {
            String sql1 = "insert into usertable(id, username, password, email, gender, birthdate) values(?,?,?,?,?,?)";
            psm = conn.prepareStatement(sql1);
            psm.setString(1, "1");
            psm.setString(2, Username);
            psm.setString(3, password);
            psm.setString(4, Email);
            psm.setString(5, gender);
            psm.setString(6, Birthdate);
            psm.executeUpdate();

            String sql2 = "select * from usertable";
            psm = conn.prepareStatement(sql2);
            rst = psm.executeQuery();
            while (rst.next()){
                String id = rst.getString("id");
                String username2 = rst.getString("Username");
                String password2 = rst.getString("password");
                String email2 = rst.getString("Email");
                String gender2 = rst.getString("gender");
                String birthday2 = rst.getString("Birthdate");
                writer.print("<tr>");
                writer.print("<td>"+ id +"</td>");
                writer.print("<td>"+ username2 +"</td>");
                writer.print("<td>"+ password2 +"</td>");
                writer.print("<td>"+ email2 +"</td>");
                writer.print("<td>"+ gender2 +"</td>");
                writer.print("<td>"+ birthday2 +"</td>");
                writer.print("</tr>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (rst!=null){
                try {
                    rst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (psm!=null){
                try {
                    psm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        writer.print("        </table>");
        writer.print("        <hr>");
        writer.print("    </body>");
        writer.print("</html>");

        writer.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
