<%--
  Created by IntelliJ IDEA.
  User: 10963
  Date: 2020/12/19
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>关闭会话</title>
</head>
<body>
<%
    session.invalidate();
%>
</body>
</html>
