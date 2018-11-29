<%--
  Created by IntelliJ IDEA.
  User: adrian
  Date: 27.11.18
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="header.jsp"/>
    <jsp:include page="groupHeader.jsp"/>
    <title>Add Group</title>

</head>
<body>

<%--@elvariable id="group" type="java"--%>
<form:form method="post" modelAttribute="group">
    <div class="container" style="max-width: 80%">
        <div class="card">
            <div class="card-body">
                <h3>Add group:</h3>
                <div class="form-group">
                    <label for="trainingId">Training Time:</label><br>
                    <form:select class="form-control" id="trainingId" itemValue="id" itemLabel="allInfo"
                                 path="trainingDay"
                                 items="${trainings}"/><br>
                    <a href="http://localhost:8080/trainings/add">Add training time</a>
                    <form:errors cssClass="error" path="trainingDay"></form:errors>
                </div>

                <div class="form-group">
                    <label for="address">Street:</label><br>
                    <form:input id="street" path="address" type="text" class="form-control"/><br>
                    <form:errors cssClass="error" path="address"></form:errors>
                </div>

                <div class="form-group">
                    <label for="statusId">Status:</label><br>
                    <form:select id="statusId" class="form-control" path="status">
                        <form:options/>
                    </form:select>
                    <form:errors cssClass="error" path="status"></form:errors>
                </div>

                <input type="submit" value="Save">
            </div>
        </div>
    </div>
</form:form>
</body>
</html>
