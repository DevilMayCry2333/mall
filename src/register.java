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

public class register extends HttpServlet {

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("UTF-8");
      response.setCharacterEncoding("UTF-8");
      response.setContentType("text/html; charset=utf-8");
      this.doPost(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("UTF-8");
      response.setCharacterEncoding("UTF-8");
      response.setContentType("text/html; charset=utf-8");
      String JDBC_DRIVER = "com.mysql.jdbc.Driver";
      String USER = "guest";
      String PASS = "guest520";
      String DBName = "mall";
      String reguser = request.getParameter("user");
      String regpass = request.getParameter("password");
      String connUrl = "jdbc:mysql://123.207.30.199:3306/mall?user=guest&password=guest520&useUnicode=true&charset=utf-8&useSSL=true";
      Boolean fail = Boolean.valueOf(false);
      boolean var25 = false;

      PrintWriter out2;
      label183: {
         try {
            var25 = true;
            if(reguser != null && !reguser.isEmpty() && regpass != null && !regpass.isEmpty()) {
               Class.forName("com.mysql.jdbc.Driver").newInstance();
               Connection out22 = DriverManager.getConnection(connUrl);
               Statement stmt = out22.createStatement();
               stmt.executeQuery("SET NAMES utf8mb4");
               String sql = "insert into user_info(username,pass)values(\'" + reguser + "\',\'" + regpass + "\')";
               String sql3 = "insert into ShoppingCart(username,field)values(\'" + reguser + "\',\'null\')";
               String sql2 = "SELECT username FROM user_info WHERE username=\'" + reguser + "\'";
               ResultSet rs = stmt.executeQuery(sql2);
               if(rs.next()) {
                  response.setContentType("text/html; charset=utf-8");
                  PrintWriter ex = response.getWriter();
                  fail = Boolean.valueOf(true);
                  ex.println("<HTML>");
                  ex.println("<HEAD><TITLE>A SERVLET</TITLE></HEAD>");
                  ex.println("<BODY>");
                  ex.println("重复名字");
                  ex.println("</BODY>");
                  ex.println("</HTML>");
                  ex.println("<a href=\'index.jsp\'>返回主页</a>");
                  ex.flush();
                  ex.close();
                  var25 = false;
               } else {
                  label159: {
                     try {
                        stmt.execute(sql);
                        stmt.execute(sql3);
                        break label159;
                     } catch (Exception var30) {
                        var30.printStackTrace();
                     } finally {
                        stmt.close();
                        out22.close();
                     }

                     var25 = false;
                     break label183;
                  }

                  var25 = false;
               }
            } else {
               out2 = response.getWriter();
               out2.println("<HTML>");
               out2.println("<HEAD><TITLE>A SERVLET</TITLE></HEAD>");
               out2.println("<BODY>");
               out2.println("用户名和密码不能为空");
               out2.println("</BODY>");
               out2.println("</HTML>");
               out2.println("<a href=\'index.jsp\'>返回主页</a>");
               out2.flush();
               out2.close();
               var25 = false;
            }
            break label183;
         } catch (Exception var32) {
            var32.printStackTrace();
            var25 = false;
         } finally {
            if(var25) {
               if(!fail.booleanValue()) {
                  response.setContentType("text/html; charset=utf-8");
                  PrintWriter out21 = response.getWriter();
                  out21.println("<HTML>");
                  out21.println("<HEAD><TITLE>A SERVLET</TITLE></HEAD>");
                  out21.println("<BODY>");
                  out21.println("注册成功");
                  out21.println(reguser);
                  out21.println("</BODY>");
                  out21.println("</HTML>");
                  out21.println("<a href=\'index.jsp\'>返回主页</a>");
                  out21.flush();
                  out21.close();
               }

            }
         }

         if(!fail.booleanValue()) {
            response.setContentType("text/html; charset=utf-8");
            out2 = response.getWriter();
            out2.println("<HTML>");
            out2.println("<HEAD><TITLE>A SERVLET</TITLE></HEAD>");
            out2.println("<BODY>");
            out2.println("注册成功");
            out2.println(reguser);
            out2.println("</BODY>");
            out2.println("</HTML>");
            out2.println("<a href=\'index.jsp\'>返回主页</a>");
            out2.flush();
            out2.close();
         }

         return;
      }

      if(!fail.booleanValue()) {
         response.setContentType("text/html; charset=utf-8");
         out2 = response.getWriter();
         out2.println("<HTML>");
         out2.println("<HEAD><TITLE>A SERVLET</TITLE></HEAD>");
         out2.println("<BODY>");
         out2.println("注册成功");
         out2.println(reguser);
         out2.println("</BODY>");
         out2.println("</HTML>");
         out2.println("<a href=\'index.jsp\'>返回主页</a>");
         out2.flush();
         out2.close();
      }

   }
}
