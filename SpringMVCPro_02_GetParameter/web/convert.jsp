<%--
  Created by IntelliJ IDEA.
  User: lyd20
  Date: 2019/3/30
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/convert" method="post">
        年龄：<input type="text" name="age">
        生日：<input type="text" name="date">
        姓名：<input type="text" name="name">
        <input type="submit" value="提交">
    </form>
</body>
</html>
