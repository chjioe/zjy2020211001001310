<%--
  Created by IntelliJ IDEA.
  User: zjy
  Date: 2022/3/7
  Time: 23:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>New User Registration</title>
    <style>
        body, html{
            font-family: Ariel, sans-serif;
            width:100%;
            height:100%;
            margin:0;
            padding:0;
            display:inline-block;
        }
        .s{
            display:flex;
            flex-flow:row;
            flex-wrap:nowrap;
            align-items:center;
            justify-content:center;
            width:100%;
            text-align: center;
            height:70%;
            background-color: #0f95b0;
        }
     </style>
</head>
<body>
<div class="s">
<form action="${pageContext.request.contextPath}/register" align="center" name="form1" method="post" onsubmit="return on_submit()">
    <h2>New User Registration!</h2><br>
    <input type="text"  name="Username"id="1" placeholder="Username" style="background-color: antiquewhite;width: 200px"><br>
    <input type="text" name="password" id="2" placeholder="password" style="background-color: antiquewhite;width: 200px"><br>
    <input type="text" name="Email" id="3" placeholder=Email style="background-color: antiquewhite;width: 200px"><br>
    <strong>Gender</strong> <input type="radio" name="gender" value="男">Male
    <input type="radio" name="gender" value="女">Female<br>
    <input type="date" name="Birthdate" placeholder="Date of birth(XXXX-XX-XX)" style="background-color: antiquewhite;width: 200px"><br>
    <input type="submit" value="Register" style="background-color: chartreuse">
</form>
</div>
</body>
</html>

