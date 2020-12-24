<%--
  Created by IntelliJ IDEA.
  User: 10963
  Date: 2020/12/16
  Time: 23:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Computer分页查询</title>
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
                <h2>Computer数据</h2>
                <table>
                    <tr>
                        <th>id</th>
                        <th>品牌</th>
                        <th>型号</th>
                        <th>处理器型号</th>
                        <th>显卡型号</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${requestScope.computerList}" var="computer">
                        <tr>
                            <td>${computer.cid}</td>
                            <td>${computer.cBrand}</td>
                            <td>${computer.cModel}</td>
                            <td>${computer.cCpu}</td>
                            <td>${computer.cGpu}</td>
                            <td>
                                <a href="/deteteComputer.do?cid=${computer.cid}">删除</a>
                                <a href="/toUpdateComputer.do?cid=${computer.cid}">修改</a>
                            </td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td colspan="6" align="center">
                            <a href="/toAddComputer.jsp">新增</a>
                        </td>
                    </tr>
                    <tr>
                        <%--页面处理代码--%>
                        <td colspan="6">
                            当前第${requestScope.page.curPageNo}&nbsp;&nbsp;
                            共${requestScope.page.pageTotalCount}页&nbsp;&nbsp;
                            总共${requestScope.page.totalCount}条数据&nbsp;&nbsp;
                            <%--仅在非第一页的时候显示首页和第一页--%>
                            <c:if test="${requestScope.page.curPageNo>1}">
                                <a href="/computerPage.do?curPageNo=1">首页</a>&nbsp;
                                <a href="/computerPage.do?curPageNo=${requestScope.page.curPageNo-1}">上一页</a>&nbsp;
                            </c:if>
                            <%--仅在非最后一页的时候显示末页和下一页--%>
                            <c:if test="${requestScope.page.curPageNo<requestScope.page.pageTotalCount}">
                                <a href="/computerPage.do?curPageNo=${requestScope.page.curPageNo+1}">下一页</a>&nbsp;
                                <a href="/computerPage.do?curPageNo=${requestScope.page.pageTotalCount}">末页</a>&nbsp;
                            </c:if>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</body>
</html>
