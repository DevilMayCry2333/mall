<%--
  Created by IntelliJ IDEA.
  User: youkaiyu
  Date: 2017/8/16
  Time: 上午10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  request.setCharacterEncoding("UTF-8");
  response.setCharacterEncoding("UTF-8");
  response.setContentType("text/html; charset=utf-8");

%>
<html>
  <head>
    <title>商场beta版</title>
    <style>
      .right{
        position: absolute;
        right: 0px;
        width: 300px;
      }

    </style>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
  </head>
<body>
<div class="right">
  <a href="index.jsp">首页</a>
  <a href="ShoppingCart.jsp">购物车</a>
  <a href="register.jsp">注册</a>
  <a href="login.jsp">登录</a>
  <a href="exit.jsp">退出</a>
  <%
    HttpSession session2=request.getSession(false);
  String username= (String) session2.getAttribute("loginname");
  if(username!=null) {
      response.setContentType("text/html ; charset=utf-8");
      out.println("欢迎" + username);
     // System.out.println(username);

  }
  else {
      out.println("您还未登录");
  }

  %>
</div>
<h3>小龙虾</h3>

<div style="width:50%;hight:100%;float:left">
<img src="images/food/00A001.jpeg" height="300px" width="300px">

<form action="ShowDetails.jsp" name="00A001" method="post">
  <input type="hidden" value="00A001" name="ShowDetails">
  <input type="submit" value="查看详情">
</form>

<form action="addCart.jsp" method="post" name="00A001">
  <input type="hidden" value="00A001" name="addCart">
  <input type="submit" value="添加购物车">
</form>
</div>
<div style="width:50%;hight:100%;float:left">
  <h3>面包</h3>
  <img src="images/food/00B001.jpeg" height="300px" width="300px">
  <form action="ShowDetails.jsp" name="00B001" method="post">
    <input type="hidden" value="00B001" name="ShowDetails">
    <input type="submit" value="查看详情">
  </form>
<form action="addCart.jsp" method="post" name="00B001" name="addCart">
  <input type="hidden" value="00B001" name="addCart">
  <input type="submit" value="添加购物车" >
</form>
</div>

<div style="width:50%;hight:100%;float:left">
<h3>电脑</h3>
<img src="images/computer/00C001.jpeg" height="300px" width="300px">
<form action="ShowDetails.jsp" name="00C001" method="post">
  <input type="hidden" value="00C001" name="ShowDetails">
  <input type="submit" value="查看详情">
</form>
<form action="addCart.jsp" method="post" name="00D001">
  <input type="hidden" value="00C001" name="addCart">
  <input type="submit" value="添加购物车" >
</form>
</div>

  </body>
</html>
