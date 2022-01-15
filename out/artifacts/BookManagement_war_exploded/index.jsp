<%--
  Created by IntelliJ IDEA.
  User: peggy
  Date: 2022/1/5
  Time: 0:12
  To change this template use File | Settings | File Templates.
--%>


<%--这个是主界面--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="Book.css">

<html>
  <head>
    <title>Peggy图书管理系统--主页</title>
    <script language=JavaScript>
      var timerID = null;
      var timerRunning = false;
      function stopclock() {
        if (timerRunning)
          clearTimeout(timerID);
        timerRunning = false;
      }
      function startclock() {
        stopclock();
        showtime();
      }

      function showtime() {
        var now = new Date();

        document.clock.thetime.value = now.toString();
        timerID = setTimeout("showtime()", 1000);
        timerRunning = true;
      }
    </script>
  </head>


  <body onload="showtime()">
  <div id="Insert" style="text-align:center; vertical-align:middle;">
    <form  name=clock >
      <marquee>当前时间：<input style="width:420px; height:20px; background:transparent" name=thetime>   欢迎使用peggy图书管理系统   </marquee>
    </form>
    <h1>欢迎来到主页<br></h1>
    <a href="./bookInsert.jsp" target="main"><button class="but" type="submit">图书信息录入</button></a>

  </br>
  </br>

    <a href="./bookQuery.jsp" target="main"><button class="but" type="submit">图书查询</button></a>
    <br/>
  </div>
  </body>
</html>
