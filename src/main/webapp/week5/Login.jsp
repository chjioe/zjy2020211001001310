<%--
  Created by IntelliJ IDEA.
  User: zjy
  Date: 2022/3/28
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="header.jsp"%>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Login</h1>
<form action="<%=request.getContextPath()%>/login" method="post">
    UserName:<input type="text" name="username"> <br>
    Password:<input type="password" name="password"> <br>
    <input type="submit" value="Login">
</form>
</body>
</html>

<%@include file="footer.jsp"%>
