<%--
  Created by IntelliJ IDEA.
  User: 10963
  Date: 2020/12/10
  Time: 23:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>登录</title>
    <style>
      #error {
        color: red;
      }
      #login {
        text-align: center;
      }
      table{
        margin:auto;
      }
    </style>
    <script type="text/javascript" src="../js/jquery-3.5.1.min.js"></script>
    <script type="text/javascript">
      function verify(){
        var regNull = /^\s*$/g;
        //console.log("????");
        var username = $("#username").val();
        var password = $("#password").val();
        if (regNull.test(username)) {
          //alert("用户名不能为空");
          $("#userError").html("用户名不能为空").css("color", "red");
          return false;
        }else {
          $("#userError").html("正确").css("color", "green");
        }

        if (regNull.test(password)) {
          $("#pwdError").html("密码不能为空").css("color", "red");
          return false;
        } else {
          $("#pwdError").html("正确").css("color", "green");
        }
      }
    </script>
  </head>
  <body>
    <div id="login">
      <div id="error">${msg}</div>
      <form action="/login.do" method="get" onsubmit="return verify()">
        <table>
          <tr>
            <td>用户名：</td>
            <td>
              <input type="text" name="username" placeholder="用户名" id="username">
              <span id="userError"></span>
            </td>
          </tr>
          <tr>
            <td>密码：</td>
            <td>
              <input type="password" name="password" placeholder="密码" id="password"/>
              <span id="pwdError"></span>
            </td>
          </tr>
          <tr>
            <td align="center">
              <input type="submit" value="提交">
              <input type="reset" value="重置">
            </td>
          </tr>
        </table>
      </form>
    </div>
  </body>
</html>
