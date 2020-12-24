<%--
  Created by IntelliJ IDEA.
  User: 10963
  Date: 2020/12/14
  Time: 13:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改dog</title>
    <style type="text/css">
        div{
            width: 500px;
            margin: 0 auto;
        }
    </style>
</head>
<body>
<div>
    <form action="/updateDog.do" method="post">
        <%--用隐藏域的方式将did传至后台--%>
        <input type="hidden" value="${requestScope.dog.did}" name="did">
        <table>
            <tr>
                <td>名字</td>
                <td><input type="text" name="d_name" value="${requestScope.dog.dname}"></td>
            </tr>
            <tr>
                <td>品种</td>
                <td><input type="text" name="d_species" value="${requestScope.dog.dspecies}"></td>
            </tr>
            <tr>
                <td>年龄</td>
                <td><input type="text" name="d_age" value="${requestScope.dog.age}"></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="提交"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
