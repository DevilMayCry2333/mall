package com.mall.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShoppingCart extends HttpServlet {

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("UTF-8");
      response.setCharacterEncoding("UTF-8");
      response.setContentType("text/html; charset=utf-8");
      this.doPost(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String JDBC_DRIVER = "com.mysql.jdbc.Driver";
      String USER = "guest";
      String PASS = "guest520";
      String DBName = "mall";
      PrintWriter out = response.getWriter();
      String connUrl = "jdbc:mysql://XXXXXX:3306/mall?user=guest&password=guest520&useUnicode=true&charset=utf-8&useSSL=true";
      HttpSession session2 = request.getSession(false);
      String user_name = (String)session2.getAttribute("loginname");
      if(user_name == null) {
         out.println("您还未登录，请登录后再试");
         out.flush();
      } else {
         try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection e = DriverManager.getConnection(connUrl);
            Statement stmt1 = e.createStatement();
            Statement stmt2 = e.createStatement();
            Statement stmt3 = e.createStatement();
            Statement stmt4 = e.createStatement();
            HttpSession session3 = request.getSession(false);
            String u = (String)session3.getAttribute("loginname");
            String sql_q = "SELECT * FROM ShoppingCart WHERE username=\'" + u + "\'";

            try {
               ResultSet ex = stmt1.executeQuery(sql_q);
               int i = 1;
               double totalprice = 0.0D;
               boolean t = true;
               if(ex.next()) {
                  for(; !Objects.equals(ex.getString(i), "null"); ++i) {
                     if(i != 6) {
                        out.println(ex.getString(i));
                     }

                     String sq;
                     ResultSet rc;
                     if(Objects.equals(ex.getString(i), "00A001")) {
                        sq = "SELECT * FROM price WHERE name=\'00A001\'";
                        rc = stmt2.executeQuery(sq);
                        if(rc.next()) {
                           totalprice += rc.getBigDecimal(2).doubleValue();
                        }

                        out.println("单价: " + rc.getBigDecimal(2).doubleValue());
                        rc.close();
                     }

                     if(Objects.equals(ex.getString(i), "00B001")) {
                        sq = "SELECT * FROM price WHERE name=\'00B001\'";
                        rc = stmt3.executeQuery(sq);
                        if(rc.next()) {
                           totalprice += rc.getBigDecimal(2).doubleValue();
                        }

                        out.println("单价: " + rc.getBigDecimal(2).doubleValue());
                        rc.close();
                     }

                     if(Objects.equals(ex.getString(i), "00C001")) {
                        sq = "SELECT * FROM price WHERE name=\'00C001\'";
                        rc = stmt4.executeQuery(sq);
                        if(rc.next()) {
                           totalprice += rc.getBigDecimal(2).doubleValue();
                        }

                        out.println("单价: " + rc.getBigDecimal(2).doubleValue());
                        rc.close();
                     }
                  }

                  out.println("<br/>总价:" + totalprice);
                  out.println("<a href=\"index.jsp\">返回首页</a>");
               }
            } catch (Exception var30) {
               var30.printStackTrace();
            } finally {
               stmt1.close();
               stmt2.close();
               stmt3.close();
               stmt4.close();
               e.close();
            }
         } catch (Exception var32) {
            var32.printStackTrace();
         }
      }

   }
}
