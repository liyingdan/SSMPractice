<%--
  Created by IntelliJ IDEA.
  User: lyd20
  Date: 2019/4/10
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <form action="${pageContext.request.contextPath}/addCustomer">
      客户名称:<input type="text" name="cust_name"> <br>
      客户职业:<input type="text" name="cust_profession"/> <br>
      客户电话: <input type="text" name="cust_phone"/> <br>
      客户邮件: <input type="text" name="email"/> <br>
      <input type="submit" value="添加">
    </form>

  </body>
</html>
