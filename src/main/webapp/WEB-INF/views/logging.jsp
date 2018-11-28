<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: adrian
  Date: 23.11.18
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log in</title>
</head>
<body>
<%--@elvariable id="user" type="java"--%>
<form:form method="post" modelAttribute="user">
    <div>
        <label for="username">Username:</label><br>
        <form:input id="username" path="username" type="text"/><br>
    </div>

    <div>
        <label for="password">Password:</label><br>
        <form:input id="password" path="password" type="password"/><br>
    </div>

    <br><input type="submit" value="Log in">

</form:form>
</body>
</html>
