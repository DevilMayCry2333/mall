<%--
  Created by IntelliJ IDEA.
  User: youkaiyu
  Date: 2017/8/16
  Time: 上午11:10
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
    <title>加入购物车👀</title>
</head>
<body>
<jsp:forward page="/addCart"/>

</body>
</html>
