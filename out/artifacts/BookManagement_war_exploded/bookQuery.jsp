<%--
  Created by IntelliJ IDEA.
  User: peggy
  Date: 2022/1/5
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Peggy图书管理系统--图书查询</title>
    <link rel="stylesheet" type="text/css" href="Book.css">
</head>
<body>
<div id="Insert" style="text-align:center; vertical-align:middle;">
    <h1>请输入您想查询的书名:<br></h1>

<form method = "post" action="query.let?book=query" >
    <input type="text" name="title"><br>
    <button class="but" type="submit" value="提交">提交</form>
</form>
    </div>
</body>
</html>
