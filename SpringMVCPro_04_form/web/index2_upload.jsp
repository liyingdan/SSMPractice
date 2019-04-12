<%--
  Created by IntelliJ IDEA.
  User: lyd20
  Date: 2019/4/1
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/download/lyd1.jpg">下载图1</a>
<a href="${pageContext.request.contextPath}/download/李应丹.jpg">下载图2</a>

<hr/>
<form action="${pageContext.request.contextPath}/upload" method="post" enctype="multipart/form-data">
    <input type="file" name="file"><br/>
    <input type="submit" value="上传">
</form>

<a href="${pageContext.request.contextPath}/local">测试本地化，国际化</a>


</body>
</html>
