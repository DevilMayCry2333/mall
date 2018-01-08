<%--
  Created by IntelliJ IDEA.
  User: youkaiyu
  Date: 2017/8/16
  Time: 上午10:49
  To change this template use File | Settings | File Templates.
--%>
<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    response.setContentType("text/html; charset=utf-8");
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购物车结算页面</title>
</head>
<body>
<jsp:forward page="/ShoppingCart"/>

</body>
</html>
