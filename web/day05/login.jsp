<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/11
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>


    </script>
</head>
<body>

    <%--作业：必需在前端验证，， 用户名，密码不能为空--%>
    <form method="post" action="${pageContext.request.contextPath}/login.do" >

        用户名：<input name="userName"> <br>
        密码：<input name="pwd" type="password"><br>
        <input type="submit" value="登陆">


    </form>

</body>
</html>
