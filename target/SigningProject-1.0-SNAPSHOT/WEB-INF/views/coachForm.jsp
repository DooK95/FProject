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
    <jsp:include page="coachHeader.jsp"/>
    <title>Add Coach</title>

</head>
<body>

<%--@elvariable id="coach" type="java"--%>
<form:form method="post" modelAttribute="coach">
    <div class="container" style="max-width: 80%">
        <div class="card">
            <div class="card-body">
                <h3>Add coach:</h3>
                <div class="form-group">
                    <label for="firstName">Name:</label><br>
                    <form:input id="firstName" path="firstName" type="text" class="form-control"/>
                    <form:errors cssClass="error" path="firstName"></form:errors>
                </div>
                <div class="form-group">
                    <label for="lastName">Surname:</label><br>
                    <form:input id="lastName" path="lastName" type="text" class="form-control"/>
                    <form:errors cssClass="error" path="lastName"></form:errors>
                </div>
                <div class="form-group">
                    <label for="email">Email:</label><br>
                    <form:input id="email" path="email" type="email" class="form-control"/>
                    <form:errors cssClass="error" path="email"></form:errors>
                </div>
                <div class="form-group">
                    <label for="phone">Phone:</label><br>
                    <form:input id="phone" path="phoneNumber" type="text" class="form-control"/>
                    <form:errors cssClass="error" path="phoneNumber"></form:errors>
                <div class="form-group">
                    <label for="permission">Permission:</label><br>
                    <form:select class="form-control" path="permission">
                        <form:options/>
                    </form:select>
                    <form:errors cssClass="error" path="permission"></form:errors>
                </div>
                <div class="form-group">
                    <label for="groupsId">Groups:</label><br>
                    <form:select class="form-control" id="groupsId" itemValue="id" itemLabel="allInfo" path="groups"
                                 items="${groups}"/><br>
                    <form:errors cssClass="error" path="groups"></form:errors>
                </div>


                <br><input type="submit" value="Save">

            </div>
        </div>
    </div>

</form:form>
</body>
</html>
