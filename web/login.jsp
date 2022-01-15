<%--
  Created by IntelliJ IDEA.
  User: peggy
  Date: 2022/1/5
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Peggy 图书管理系统--登录</title>
    <link rel="stylesheet" type="text/css" href="login.css">

</head>
<body>
<div id="login" style="text-align:center; vertical-align:middle;">
    <h1>Login</h1>
    <form method="post" action="user.let?type=login">
        <input type="text" required="required" placeholder="用户名" name="name"></input>
        <input type="password" required="required" placeholder="密码" name="pwd"></input>
        <button class="but" type="submit">登        录</button>
    </form>
</div>
</body>
</html>
