package com.mall.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowDetails extends HttpServlet {

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("UTF-8");
      response.setCharacterEncoding("UTF-8");
      response.setContentType("text/html; charset=utf-8");
      this.doPost(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      PrintWriter out = response.getWriter();
      out.println("<a href=\"index.jsp\">返回首页</a>");
      String id = request.getParameter("ShowDetails");
      String JDBC_DRIVER = "com.mysql.jdbc.Driver";
      String USER = "guest";
      String PASS = "guest520";
      String DBName = "mall";
      String connUrl = "jdbc:mysql://XXXXXX:3306/mall?user=guest&password=guest520&useUnicode=true&charset=utf-8&useSSL=true";

      try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();
      } catch (InstantiationException var28) {
         var28.printStackTrace();
      } catch (IllegalAccessException var29) {
         var29.printStackTrace();
      } catch (ClassNotFoundException var30) {
         var30.printStackTrace();
      }

      Connection conn = null;

      try {
         conn = DriverManager.getConnection(connUrl);
      } catch (SQLException var27) {
         var27.printStackTrace();
      }

      Statement stmt = null;

      try {
         stmt = conn.createStatement();
      } catch (SQLException var26) {
         var26.printStackTrace();
      }

      int result1 = id.indexOf("00A");
      int result2 = id.indexOf("00B");
      int result3 = id.indexOf("00C");
      String sql_sel;
      ResultSet rs;
      String[] data;
      int i;
      String sql_sel2;
      ResultSet rsa;
      if(result1 < 0 && result2 < 0) {
         sql_sel = "SELECT * FROM good_field WHERE good_kind=\'电脑\'";
         rs = null;

         try {
            rs = stmt.executeQuery(sql_sel);
         } catch (SQLException var25) {
            var25.printStackTrace();
         }

         data = new String[15];
         i = 1;

         try {
            while(rs.next()) {
               for(; !Objects.equals(rs.getString(i), "null"); ++i) {
                  data[i] = rs.getString(i);
                  if(i > 1) {
                     out.println(data[i]);
                  }
               }
            }
         } catch (SQLException var32) {
            var32.printStackTrace();
         }

         try {
            rs.close();
         } catch (SQLException var24) {
            var24.printStackTrace();
         }

         sql_sel2 = "SELECT * FROM computer_info WHERE id=3001";
         rsa = null;

         try {
            rsa = stmt.executeQuery(sql_sel2);
         } catch (SQLException var23) {
            var23.printStackTrace();
         }

         i = 2;

         try {
            while(rsa.next()) {
               out.println("<br/>");

               while(!Objects.equals(rsa.getString(i), "null")) {
                  out.println(rsa.getString(i));
                  ++i;
               }
            }
         } catch (SQLException var31) {
            var31.printStackTrace();
         }

         try {
            rsa.close();
         } catch (SQLException var22) {
            var22.printStackTrace();
         }
      } else {
         try {
            sql_sel = "SELECT * FROM good_field WHERE good_kind=\'水果\'";
            rs = stmt.executeQuery(sql_sel);
            data = new String[15];
            i = 1;

            while(rs.next()) {
               for(; !Objects.equals(rs.getString(i), "null"); ++i) {
                  data[i] = rs.getString(i);
                  if(i > 1) {
                     out.println(data[i]);
                  }
               }
            }

            rs.close();
            if(result1 >= 0 && result2 < 0) {
               sql_sel2 = "SELECT * FROM fruit_info WHERE 品种=\'小龙虾\'";
               rsa = stmt.executeQuery(sql_sel2);
               i = 2;

               while(rsa.next()) {
                  out.println("<br/>");

                  while(!Objects.equals(rsa.getString(i), "null")) {
                     out.println(rsa.getString(i));
                     ++i;
                  }
               }

               rsa.close();
            }

            if(result1 < 0 && result2 >= 0) {
               sql_sel2 = "SELECT * FROM fruit_info WHERE 品种=\'面包\'";
               rsa = stmt.executeQuery(sql_sel2);
               i = 2;

               while(rsa.next()) {
                  out.println("<br/>");

                  while(!Objects.equals(rsa.getString(i), "null")) {
                     out.println(rsa.getString(i));
                     ++i;
                  }
               }

               rsa.close();
            }

            stmt.close();
            conn.close();
         } catch (Exception var33) {
            var33.printStackTrace();
         }
      }

   }
}
