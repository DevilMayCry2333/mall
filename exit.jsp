<%--
  Created by IntelliJ IDEA.
  User: youkaiyu
  Date: 2017/8/16
  Time: 上午10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>

<html>
<head>
    <title>QAQ真的要退出吗</title>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />

</head>
<body>
<%
    HttpSession session1=request.getSession(false);
    String loginname= (String) session1.getAttribute("loginname");


    if(session1==null ||loginname==null ){
        out.println("已经退出"+loginname);
    }
    else{
        session1.invalidate();
        out.println("退出成功"+loginname);
    }

%>
<a href="index.jsp">返回首页</a>


</body>
</html>
