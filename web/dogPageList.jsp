<%--
  Created by IntelliJ IDEA.
  User: 10963
  Date: 2020/12/16
  Time: 22:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Dog分页查询</title>
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
                <h2>Dog数据</h2>
                <table>
                    <tr>
                        <th>id</th>
                        <th>名字</th>
                        <th>品种</th>
                        <th>年龄（月）</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${requestScope.dogList}" var="dog">
                        <tr>
                            <td>${dog.did}</td>
                            <td>${dog.dname}</td>
                            <td>${dog.dspecies}</td>
                            <td>${dog.age}</td>
                            <td>
                                <a href="/deleteDog.do?did=${dog.did}">删除</a>
                                <a href="/toUpdateDog.do?did=${dog.did}">修改</a>
                            </td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td colspan="5" align="center">
                            <a href="/toAddDog.jsp">新增</a>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="6">
                            当前第${requestScope.page.curPageNo}&nbsp;&nbsp;共${requestScope.page.pageTotalCount}页&nbsp;&nbsp;总共${requestScope.page.totalCount}条数据&nbsp;&nbsp;
                            <c:if test="${requestScope.page.curPageNo>1}">
                                <a href="/dogPage.do?curPageNo=1">首页</a>&nbsp;
                                <a href="/dogPage.do?curPageNo=${requestScope.page.curPageNo-1}">上一页</a>&nbsp;
                            </c:if>
                            <c:if test="${requestScope.page.curPageNo<requestScope.page.pageTotalCount}">
                                <a href="/dogPage.do?curPageNo=${requestScope.page.curPageNo+1}">下一页</a>&nbsp;
                                <a href="/dogPage.do?curPageNo=${requestScope.page.pageTotalCount}">末页</a>&nbsp;
                            </c:if>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</body>
</html>
