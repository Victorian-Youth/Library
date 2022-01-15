<%--
  Created by IntelliJ IDEA.
  User: peggy
  Date: 2022/1/5
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%--bookInsert.jsp 实现向数据库中插入数据--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Peggy图书管理系统--信息录入</title>
    <link rel="stylesheet" type="text/css" href="Book.css">
</head>
<body>
<div id="Insert" style="text-align:center; vertical-align:middle;">
    <h1>请输入图书信息</h1>
<% if(request.getAttribute("result")!=null)
    out.print(request.getAttribute("result"));
%>
<form action = "insert.let?type=add" method = "post">
    <table>
<%--        <tr><td>书号</td> <td><input type="text" name="bookid" ></td></tr>--%>
        <tr><td>书名</td><td><input type="text" name="title"></td></tr>
        <tr><td>作者</td><td><input type="text" name="author" ></td></tr>
        <tr><td>出版社</td><td><input type="text" name="publisher" ></td></tr>
        <tr><td>单价</td><td><input type="text" name="price" ></td></tr>
        <tr><td><input type="submit" value="确定" ></td>
            <td><input type="reset" value="重置" ></td>
        </tr>
    </table>

</form>
    <a href="./index.jsp"><button class="but" type="submit" >取        消</button></a>
</div>
</body>
</html>
