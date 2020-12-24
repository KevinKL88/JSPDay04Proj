<%--
  Created by IntelliJ IDEA.
  User: 10963
  Date: 2020/12/13
  Time: 23:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>toAddDog</title>
    <style type="text/css">
        div{
            width: 500px;
            margin: 0 auto;
        }
    </style>
    <script src="https://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
</head>
<body>
    <div>
        <form action="/addDog.do" method="post">
            <table>
                <tr>
                    <td>名字</td>
                    <td><input type="text" name="d_name" id="d_name"  onblur="checkDogName()"></td>
                    <td><span id="nameTips"></span></td>
                </tr>
                <tr>
                    <td>品种</td>
                    <td><input type="text" name="d_species"></td>
                </tr>
                <tr>
                    <td>年龄</td>
                    <td><input type="text" name="d_age"></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="提交"></td>
                </tr>
            </table>
        </form>
    </div>
    <script type="text/javascript" src="./js/checkname.js"></script>
   <%-- <script type="text/javascript">
        var timer;
        $("#d_name").on("input",function () {
            if (timer){
                timer.clearTimeout();
            }
            timer.setTimeout(function () {
                $.get("/checkDogName.do?dname="+$("#d_name").val(),function (data) {
                    $("#nameTips").html(data);
                });
            },1000);
        })
    </script>--%>
</body>
</html>
