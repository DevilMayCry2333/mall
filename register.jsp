<%--
  Created by IntelliJ IDEA.
  User: youkaiyu
  Date: 2017/8/16
  Time: 上午10:50
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
    <title>注册页面</title>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
</head>
<body>
<form method="post" name="register" action="${pageContext.request.contextPath}/register" accept-charset="UTF-8">
        <input type="text" name="user" value=""/>
        <input type="password" name="password" value=""/>
        <input type="submit" value="注册"/>
</form>

</body>
</html>
