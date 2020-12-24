<%--
  Created by IntelliJ IDEA.
  User: 10963
  Date: 2020/12/14
  Time: 21:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改Computer</title>
    <style type="text/css">
        div{
            width: 500px;
            margin: 0 auto;
        }
    </style>
</head>
<body>
<div>
    <form action="/updateComputer.do" method="post">
        <input type="hidden" name="cid" value="${requestScope.computer.cid}">
        <table>
            <tr>
                <td>品牌</td>
                <td><input type="text" name="c_brand" value="${requestScope.computer.cBrand}"></td>
            </tr>
            <tr>
                <td>型号</td>
                <td><input type="text" name="c_model" value="${requestScope.computer.cModel}"></td>
            </tr>
            <tr>
                <td>处理器型号</td>
                <td><input type="text" name="c_cpu" value="${requestScope.computer.cCpu}"></td>
            </tr>
            <tr>
                <td>显卡型号</td>
                <td><input type="text" name="c_gpu" value="${requestScope.computer.cGpu}"></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="提交"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
