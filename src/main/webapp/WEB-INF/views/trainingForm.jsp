<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: adrian
  Date: 29.11.18
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="header.jsp"/>
    <title>Add Training</title>

</head>
<body>

<%--@elvariable id="training" type="java"--%>
<form:form method="post" modelAttribute="training">
    <div class="container">
        <h3>Add Training:</h3>
        <div class="card">
            <div class="card-body">

                <div class="form-group">
                    <label for="day">Day:</label><br>
                    <form:select id="dayId" class="form-control" path="day">
                        <form:options/>
                    </form:select>
                    <form:errors cssClass="error" path="day"></form:errors>
                </div>

                <div class="form-group">
                    <label for="startTime">Start:</label><br>
                    <form:input pattern="[0-2]?[0-9]:[0-5][0-9]" title="Format hh:mm" type="time-local" path="startTime" />
                    <form:errors cssClass="error" path="startTime"></form:errors>
                </div>

                <div class="form-group">
                    <label for="endTime">End:</label><br>
                    <form:input pattern="[0-2]?[0-9]:[0-5][0-9]" title="Format hh:mm" type="time-local" path="endTime" />
                    <form:errors cssClass="error" path="endTime"></form:errors>
                </div>

                <input type="submit" value="Save">

            </div>
        </div>
    </div>

</form:form>
</body>
</html>
