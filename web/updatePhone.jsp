<%--
  Created by IntelliJ IDEA.
  User: 10963
  Date: 2020/12/14
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改Phone</title>
    <style type="text/css">
        div{
            width: 500px;
            margin: 0 auto;
        }
    </style>
</head>
<body>
<div>
    <form action="/updatePhone.do" method="post">
        <%--通过隐藏域传递pid至后台--%>
        <input type="hidden" name="pid" value="${requestScope.phone.pid}">
        <table>
            <tr>
                <td>品牌</td>
                <td><input type="text" name="p_brand" value="${requestScope.phone.pbrand}"></td>
            </tr>
            <tr>
                <td>型号</td>
                <td><input type="text" name="p_model" value="${requestScope.phone.pmodel}"></td>
            </tr>
            <tr>
                <td>屏幕尺寸</td>
                <td><input type="text" name="p_size" value="${requestScope.phone.psize}"></td>
            </tr>
            <tr>
                <td>价格</td>
                <td><input type="text" name="p_price" value="${requestScope.phone.pprice}"></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="提交"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
