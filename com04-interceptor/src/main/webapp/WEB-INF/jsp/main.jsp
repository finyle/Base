<%--
  Created by IntelliJ IDEA.
  User: lin
  Date: 2020/10/20
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>main</title>
</head>
<body>
<h1>首页</h1>
${username}
<a href="${pageContext.request.contextPath}/user/logout">注销</a>
</body>
</html>
