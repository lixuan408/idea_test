<%@ page import="java.net.URLDecoder" %><%--
  Created by IntelliJ IDEA.
  User: 李轩
  Date: 2022/6/1
  Time: 18:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>login</title>
    <link href="css/login.css" rel="stylesheet">
</head>

<body>
<div id="loginDiv" style="height: 350px">
    <form action="/brand_demo/loginServlet" id="form" method="post">
        <h1 id="loginMsg">LOGIN IN</h1>
        <div id="errorMsg">${login_error_msg}${register_msg}${Login_msg}</div>


        <p>Username:<input id="username" name="username" type="text" value=""></p>

        <p>Password:<input id="password" name="password" type="password" value="${cookie.password.value}"></p>
        <p>Remember:<input id="remember" name="remember" value="1" type="checkbox"></p>
        <div id="subDiv">
            <input type="submit" class="button" value="login up">
            <input type="reset" class="button" value="reset">&nbsp;&nbsp;&nbsp;
            <a href="/brand_demo/register.jsp">没有账号？</a>
        </div>
    </form>
</div>

</body>

<script>
    document.getElementById("username").value=decodeURI("${cookie.username.value}")
</script>
</html>
