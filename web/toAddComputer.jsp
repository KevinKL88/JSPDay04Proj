<%--
  Created by IntelliJ IDEA.
  User: 10963
  Date: 2020/12/14
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加Computer</title>
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
    <form action="/addComputer.do" method="post">
        <table>
            <tr>
                <td>品牌</td>
                <td><input type="text" name="c_brand"></td>
            </tr>
            <tr>
                <td>型号</td>
                <td><input type="text" name="c_model" id="c_model"></td>
                <td><span id="modelTips"></span></td>
            </tr>
            <tr>
                <td>处理器型号</td>
                <td><input type="text" name="c_cpu"></td>
            </tr>
            <tr>
                <td>显卡型号</td>
                <td><input type="text" name="c_gpu"></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="提交"></td>
            </tr>
        </table>
    </form>
</div>
<script type="text/javascript">
    //使用定时器
    let timer;
    //输入时触发
    $("#c_model").on("input",function (){
        if (timer){
            //当再次输入时，清除定时器
            window.clearInterval(timer);
        }
        //设置定时器，500ms后提交请求
        timer = window.setTimeout(function () {
            $.get("/checkComputerModel.do?c_model="+$("#c_model").val(),function (data) {
                $("#modelTips").html(data);
            });
        },500);
    })
</script>
</body>
</html>
