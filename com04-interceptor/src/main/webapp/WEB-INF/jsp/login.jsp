<%--
  Created by IntelliJ IDEA.
  User: lin
  Date: 2020/10/20
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<h1>登录页面</h1>
<body>
<form action="${pageContext.request.contextPath}/user/login" method="post">
    用户名：<input type="text" name="username"> <br>
    密码： <input type="password" name="pwd"> <br>
    <input type="submit" value="提交">
</form>
</body>
</html>
