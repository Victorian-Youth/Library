<%@ page import="com.book.Bean.BookBean" %>
<%@ page import="java.util.List" %>
<%@ page import="java.awt.print.Book" %><%--
  Created by IntelliJ IDEA.
  User: peggy
  Date: 2022/1/5
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="true" %>

<html>
<head>
    <title>Peggy图书管理系统--图书查询结果</title>
    <link rel="stylesheet" type="text/css" href="Book.css">
</head>
<body>
<%
List<BookBean> booksForSelectedTitle = (List<BookBean>) request.getSession().getAttribute("books");
%>

<div id="display" style="text-align:center; vertical-align:middle;">
    <h1>图书查询结果</h1>
<%--    <form action="query.let?book=query" method="post" enctype="multipart/form-data">--%>

        <%
            try{
                List<BookBean> books = (List<BookBean>) request.getSession().getAttribute("books");
                for(BookBean book:books){%>
        <tr>
            <td>书号： <%=book.getBookid() %></td>
            <td>书名：<%=book.getTitle() %></td>
            <td>作者： <%=book.getAuthor() %></td>
            <td>出版社：<%=book.getPublisher() %></td>
            <td>价格：<%=book.getPrice() %></td>
        </br>
        </tr>
                  <%
                }
            }catch (Exception e){
       } %>
    </br>
<%--    </form>--%>
            <a href="./index.jsp"><button class="but" type="submit" >返        回</button></a>
            </br>
            </br>
</div>
</body>
</html>
