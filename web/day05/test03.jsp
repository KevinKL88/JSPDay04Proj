<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/11
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--给了一个指令，我需要包含test02.jsp文件中的所有代码--%>
<%@ include file="test02.jsp"   %>

<%--<%@ include file="test02.jsp"   %> 这种只能包含一次--%>
<%--如果使用 include  转为java代码的时候只会有一个类--%>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h1>我是test03中的代码开始=============</h1>
    <%
        //int num=20;
    %>
</body>
</html>
