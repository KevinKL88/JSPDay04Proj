<%--
  Created by IntelliJ IDEA.
  User: 10963
  Date: 2020/12/19
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>统计在线人数</title>
</head>
<body>
现在在线人数为
<%
    out.print(application.getAttribute("count"));
%>
<a href="/out.jsp">关闭会话</a>
</body>
</html>
