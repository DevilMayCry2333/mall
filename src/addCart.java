package com.mall.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class addCart extends HttpServlet {

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("UTF-8");
      response.setCharacterEncoding("UTF-8");
      response.setContentType("text/html; charset=utf-8");
      this.doPost(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String id = request.getParameter("addCart");
      PrintWriter out = response.getWriter();
      String JDBC_DRIVER = "com.mysql.jdbc.Driver";
      String USER = "guest";
      String PASS = "guest520";
      String DBName = "mall";
      String connUrl = "jdbc:mysql://XXXXX:3306/mall?user=guest&password=guest520&useUnicode=true&charset=utf-8&useSSL=true";

      try {
         Class.forName("com.mysql.jdbc.Driver");
         Connection e = DriverManager.getConnection(connUrl);
         Statement stmt = e.createStatement();
         Boolean result1 = Boolean.valueOf(id.equals("00A001"));
         Boolean result2 = Boolean.valueOf(id.equals("00B001"));
         Boolean result3 = Boolean.valueOf(id.equals("00C001"));
         boolean i = true;
         HttpSession session2 = request.getSession(false);
         String user_name = (String)session2.getAttribute("loginname");
         String sql_ins;
         if(result1.booleanValue()) {
            sql_ins = "update ShoppingCart set good_1=\'" + id + "\' where username=\'" + user_name + "\'";
            stmt.executeUpdate(sql_ins);
            out.println("已成功添加购物车");
            out.println("<a href=\"index.jsp\">返回首页</a>");
         }

         if(result2.booleanValue()) {
            sql_ins = "update ShoppingCart set good_2=\'" + id + "\' where username=\'" + user_name + "\'";
            stmt.executeUpdate(sql_ins);
            out.println("已成功添加购物车");
            out.println("<a href=\"index.jsp\">返回首页</a>");
         }

         if(result3.booleanValue()) {
            sql_ins = "update ShoppingCart set good_3=\'" + id + "\' where username=\'" + user_name + "\'";
            stmt.executeUpdate(sql_ins);
            out.println("已成功添加购物车");
            out.println("<a href=\"index.jsp\">返回首页</a>");
         }

         stmt.close();
         e.close();
      } catch (Exception var19) {
         var19.printStackTrace();
      }

   }
}
