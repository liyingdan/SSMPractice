<%--
  Created by IntelliJ IDEA.
  User: lyd20
  Date: 2019/3/31
  Time: 23:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="fm"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>result----------</h1>
    <fm:form modelAttribute="user" action="${pageContext.request.contextPath}/update2">
        姓名：<fm:input path="username"/><fm:errors path="username" cssStyle="color: red;"/> <br/>
        年龄：<fm:input path="age"/><fm:errors path="age"/><br/>
        性别：<fm:radiobutton path="gender" value="0" label="男"/>
              <fm:radiobutton path="gender" value="1" label="女"/><br/>
        爱好：<fm:checkboxes path="hobby" items="${allhobby}"/><br/>
        宠物：<fm:select path="pet.id" items="${petList}" itemValue="id" itemLabel="name"/><br/>
        <input type="submit" value="修改">
    </fm:form>

</body>
</html>
