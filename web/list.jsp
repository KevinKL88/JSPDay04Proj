<%--
  Created by IntelliJ IDEA.
  User: 10963
  Date: 2020/12/11
  Time: 1:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
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
                <h2>用户数据</h2>
                <table>
                    <tr>
                        <th>id</th>
                        <th>用户名</th>
                        <th>密码</th>
                        <th>地址</th>
                    </tr>
                    <c:forEach items="${requestScope.userList}" var="user">
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.username}</td>
                            <td>${user.password}</td>
                            <td>${user.address}</td>
                        </tr>
                    </c:forEach>
                </table>
            </form>
        </div>
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
               </table>
           </form>
       </div>
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
                </table>
            </form>
        </div>
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
                </table>
            </form>
        </div>
    </div>
</body>
</html>
