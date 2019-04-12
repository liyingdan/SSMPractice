<%--
  Created by IntelliJ IDEA.
  User: lyd20
  Date: 2019/4/2
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>local</h1>
    <hr/>
    <a href="?language=zh_CN"><fmt:message key="language.cn"/> </a>
    <a href="?language=en_US"><fmt:message key="language.en"/></a>

    <fmt:message key="welcome"/>
    <fmt:message key="name"/>
</body>
</html>
