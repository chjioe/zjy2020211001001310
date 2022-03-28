package com.zhangjinyang.week3.demo;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(
        urlPatterns = "/register",
        loadOnStartup = 1
)
public class RegisterServlet extends HttpServlet {
    Connection conn = null;

    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext context = getServletContext();
        String driver = context.getInitParameter("driver");
        String url = context.getInitParameter("url");
        String username = context.getInitParameter("username");
        String password = context.getInitParameter("password");

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,username,password);
            System.out.println("Connection --> "+conn);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String birthdate = request.getParameter("birthdate");

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print("        <!DOCTYPE html>");
        out.print("<html>");
        out.print("    <head>");
        out.print("        <meta charset='UTF-8'>");
        out.print("        <title>UserList</title>");

        out.print("    </head>");
        out.print("    <body>");
        out.print("        <h1 align='center'>UserList</h1>");
        out.print("        <hr>");
        out.print("        <table border='1px' align='center' width='50%'>");
        out.print("            <tr>");
        out.print("                <th>ID</th>");
        out.print("                <th>UserName</th>");
        out.print("                <th>Password</th>");
        out.print("                <th>Email</th>");
        out.print("                <th>Gender</th>");
        out.print("                <th>Birthdate</th>");
        out.print("            </tr>");

        String sql1 = "INSERT INTO usertable VALUES(?,?,?,?,?,?)";
        String sql2 = "SELECT * FROM usertable";
        try {
            PreparedStatement ps = conn.prepareStatement(sql1);
            Statement sm = conn.createStatement();
            ps.setInt(1,1);
            ps.setString(2,username);
            ps.setString(3,password);
            ps.setString(4,email);
            ps.setString(5,gender);
            ps.setDate(6, Date.valueOf(birthdate));
            ps.executeUpdate();
            ResultSet rs = sm.executeQuery(sql2);
            while (rs.next()){
                int id = rs.getInt("id");
                String username1 = rs.getString("username");
                String password1 =rs.getString("password");
                String email1 = rs.getString("email");
                String gender1 = rs.getString("gender");
                String birthdate1 = rs.getString("birthdate");
                out.println("           <tr>");
                out.println(               "<td>"+id+"</td>");
                out.println(               "<td>"+username1+"</td>");
                out.println(               "<td>"+password1+"</td>");
                out.println(               "<td>"+email1+"</td>");
                out.println(               "<td>"+gender1+"</td>");
                out.println(               "<td>"+birthdate1+"</td>");
                out.println("           </tr>");
            }
            rs.close();
            sm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        out.println("       </table>");
        out.println("   </body>");
        out.println("</html>");
        out.close();


    }

    @Override
    public void destroy() {
        super.destroy();
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
