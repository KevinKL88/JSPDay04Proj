<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 10963
  Date: 2020/12/16
  Time: 12:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Phone分页查询</title>
    <style type="text/css">
        #divOut{
            text-align: center;
            height: auto;
            width: 80%;
            margin:0 auto;
        }
        .divInside{
            text-align: center;
            width: 600px;
            margin:0 auto;
        }
        table{
            text-align: center;
            margin: auto;
            border: 1px solid black;
            border-collapse:collapse;
        }
        table tr,th,td{
            border: 1px solid black;
        }
        a{
            text-decoration: none;
        }
    </style>
</head>
<body>
    <div id="divOut">
        <div class="divInside">
            <form>
                <h2>Phone数据</h2>
                <table>
                    <tr>
                        <th>id</th>
                        <th>品牌</th>
                        <th>型号</th>
                        <th>屏幕尺寸</th>
                        <th>价格</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${requestScope.phoneList}" var="phone">
                        <tr>
                            <td>${phone.pid}</td>
                            <td>${phone.pbrand}</td>
                            <td>${phone.pmodel}</td>
                            <td>${phone.psize}</td>
                            <td>${phone.pprice}</td>
                            <td>
                                <a href="/deletePhone.do?pid=${phone.pid}">删除</a>
                                <a href="/toUpdatePhone.do?pid=${phone.pid}">修改</a>
                            </td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td colspan="6" align="center">
                            <a href="/toAddPhone.jsp">新增</a>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="6">
                            当前第 ${requestScope.page.curPageNo}页  &nbsp;&nbsp; 总共  ${requestScope.page.pageTotalCount}页 &nbsp;&nbsp;总共 ${requestScope.page.totalCount}  条数据
                            <c:if test="${requestScope.page.curPageNo>1}">
                                <a href="/phonePage.do?curPageNo=1">首页</a>&nbsp;
                                <a href="/phonePage.do?curPageNo=${requestScope.page.curPageNo-1}">上一页</a>&nbsp;
                            </c:if>
                            <%--<span><a href="/phonePage.do?curPageNo=2">2</a></span>--%>
                            <c:if test="${requestScope.page.curPageNo<requestScope.page.pageTotalCount}">
                                <a href="/phonePage.do?curPageNo=${requestScope.page.curPageNo+1}">下一页</a>&nbsp;
                                <a href="/phonePage.do?curPageNo=${requestScope.page.pageTotalCount}">末页</a>&nbsp;
                            </c:if>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</body>
</html>
