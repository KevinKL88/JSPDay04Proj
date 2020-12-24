<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/11
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%--jsp可以包含 java  与  html代码--%>

    <%--java代码--%>
    <%
        //java代码定义在这里面
        int i=10;
        //System.out.println(i); 以后开发不可能写
        Date date = new Date();
    %>
    <%--输入变量i的值--%>
    <%=i%>
    <br>
    <%=date%>

    <%-- 按住ctrl+shift  +/ 注释就出来了--%>
    <%--jsp中有两种注释--%>

    <!--这是html注释  查看源代码的时候可以看到-->

    <%--这是jsp注释  查看源代码的时候看不到--%>

    <h1>这就是html代码</h1>

</body>
</html>
