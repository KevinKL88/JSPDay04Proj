<%@ page import="com.lkl.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: 10963
  Date: 2020/12/13
  Time: 18:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        //判断是否已经登录
        User user = (User) session.getAttribute("user_log");
        out.print(user);
        if (user == null) {
            //未登录则跳转到登录页面
            response.sendRedirect("/login.jsp");
        }
    %>
</body>
</html>
