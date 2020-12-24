<%@ page import="java.util.List" %>
<%@ page import="com.javacto.po.User" %>
<%@ page import="com.javacto.service.UserService" %>
<%@ page import="com.javacto.service.UserServiceImpl" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/11
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


    查询所有
    <table border="1" cellpadding="0" cellspacing="0" width="60%">
        <tr>
            <td>t_id/td></td>
            <td>t_name</td>
            <td>sex</td>
            <td>t_date</td>
            <td>address</td>
            <td>操作</td>
        </tr>

    <%
        /*这是jsp内置对象  request   out  */
        List<User> users= (List<User>) request.getAttribute("users");
        //这里其实可以直接调用业务层的代码，就是 servlet代码可以不写
       /* UserService userService = new UserServiceImpl();
        List<User> users= userService.queryAll();*/

        for (User u:users){


    %>
    <%--在这里写html代码开始--%>

        <tr>
            <td><%=u.getT_id()%></td>
            <td><%=u.getT_name()%></td>
            <td><%=u.getSex()%></td>
            <td><%=u.getT_date()%></td>
            <td><%=u.getAddress()%></td>
            <td>操作</td>
        </tr>


    <%--在这里写html代码开结束 --%>

    <%
        }
    %>

    </table>




</body>
</html>
