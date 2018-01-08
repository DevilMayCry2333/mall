package com.mall.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class login extends HttpServlet {

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("UTF-8");
      response.setCharacterEncoding("UTF-8");
      response.setContentType("text/html; charset=utf-8");
      this.doPost(request, response);
   }

   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      Boolean fail = Boolean.valueOf(false);
      request.setCharacterEncoding("UTF-8");
      response.setCharacterEncoding("UTF-8");
      response.setContentType("text/html; charset=utf-8");
      String JDBC_DRIVER = "com.mysql.jdbc.Driver";
      String USER = "guest";
      String PASS = "guest520";
      String DBName = "mall";
      String chkuser = request.getParameter("user");
      String chkpass = request.getParameter("password");
      String connUrl = "jdbc:mysql://XXXX:3306/mall?user=guest&password=guest520&useUnicode=true&charset=utf-8&useSSL=true";

      try {
         Class.forName("com.mysql.jdbc.Driver");
         Connection e = DriverManager.getConnection(connUrl);
         Statement stmt = e.createStatement();
         stmt.executeQuery("SET NAMES utf8mb4");
         String sql_check = "SELECT username,pass FROM user_info WHERE username=\'" + chkuser + "\'AND pass=\'" + chkpass + "\'";

         try {
            HttpSession ex = request.getSession(false);
            if(ex.getAttribute("loginname") == null) {
               ResultSet out2 = stmt.executeQuery(sql_check);
               PrintWriter out1;
               if(out2.next()) {
                  response.setContentType("text/html; charset=utf-8");
                  out1 = response.getWriter();
                  out1.println("<HTML>");
                  out1.println("<HEAD><TITLE>A SERVLET</TITLE></HEAD>");
                  out1.println("<BODY>");
                  out1.println("登录成功");
                  out1.println("</BODY>");
                  out1.println("</HTML>");
                  out1.println("<a href=\'index.jsp\'>返回主页</a>");
                  out1.flush();
                  out1.close();
                  HttpSession session = request.getSession();
                  session.setAttribute("loginname", chkuser);
               } else {
                  fail = Boolean.valueOf(true);
                  response.setContentType("text/html; charset=utf-8");
                  out1 = response.getWriter();
                  out1.println("<HTML>");
                  out1.println("<HEAD><TITLE>A SERVLET</TITLE></HEAD>");
                  out1.println("<BODY>");
                  out1.println("登录失败,用户名或者密码错误");
                  out1.println("</BODY>");
                  out1.println("</HTML>");
                  out1.println("<a href=\'index.jsp\'>返回主页</a>");
                  out1.flush();
                  out1.close();
               }
            } else {
               response.setContentType("text/html; charset=utf-8");
               PrintWriter out21 = response.getWriter();
               out21.println("<HTML>");
               out21.println("<HEAD><TITLE>A SERVLET</TITLE></HEAD>");
               out21.println("<BODY>");
               out21.println("您已经成功登录，请不要重复登录");
               out21.println("</BODY>");
               out21.println("</HTML>");
               out21.println("<a href=\'index.jsp\'>返回主页</a>");
               out21.flush();
               out21.close();
            }
         } catch (Exception var22) {
            var22.printStackTrace();
            response.getWriter().write(var22.toString());
         } finally {
            stmt.close();
            e.close();
         }
      } catch (Exception var24) {
         var24.printStackTrace();
         response.getWriter().write(var24.toString());
      }

   }
}
