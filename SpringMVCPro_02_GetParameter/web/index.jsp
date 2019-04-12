<%--
  Created by IntelliJ IDEA.
  User: lyd20
  Date: 2019/3/29
  Time: 20:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <a href="${pageContext.request.contextPath}/first?id=1&name=李应丹">请求转发</a>
  <hr/>

  <a href="${pageContext.request.contextPath}/second?name=李小彤">请求转发</a>
  <hr/>

  <form action="${pageContext.request.contextPath}/myform">
      user:<input type="text" name="user_name">
      age:<input type="text" name="user_age">
      <input type="submit" value="提交">
  </form>
  <hr/>

  <form action="${pageContext.request.contextPath}/myform2">
      user:<input type="text" name="user_name">
      age:<input type="text" name="user_age">
      爱好：<input type="checkbox" name="hobby" value="乒乓球">乒乓球
            <input type="checkbox" name="hobby" value="篮球">篮球
            <input type="checkbox" name="hobby" value="足球">足球
      <input type="submit" value="提交">
  </form>

  <hr/>
  <form action="${pageContext.request.contextPath}/myform3">
      user:<input type="text" name="user_name"><br/>
      age:<input type="text" name="user_age"><br/>
      爱好：<input type="checkbox" name="hobby" value="乒乓球">乒乓球
      <input type="checkbox" name="hobby" value="篮球">篮球
      <input type="checkbox" name="hobby" value="足球">足球<br/>
      ------------宠物------------<br/>
      宠物名称：<input type="text" name="dog.name"><br/>
      宠物颜色：<input type="text" name="dog.color"><br/>

      宠物名称：<input type="text" name="dogs[0].name"><br/>
      宠物颜色：<input type="text" name="dogs[0].color"><br/>

      宠物名称：<input type="text" name="dogs[1].name"><br/>
      宠物颜色：<input type="text" name="dogs[1].color"><br/>

      <input type="submit" value="提交">
  </form>

  </body>
</html>
