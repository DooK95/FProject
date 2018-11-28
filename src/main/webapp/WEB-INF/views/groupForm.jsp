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
    <title>Title</title>

</head>
<body>

<%--@elvariable id="group" type="java"--%>
<form:form method="post" modelAttribute="group">
    <div class="container">
        <h3>Add coach:</h3>
        <div class="card">
            <div class="card-body">

                <div class="form-group">
                    <label for="address">Street:</label><br>
                    <form:input id="street" path="address" type="text" class="form-control"/><br>
                    <form:errors cssClass="error" path="address"></form:errors>
                </div>

                <div class="form-group">
                    <label for="trainingId">Training Time:</label><br>
                    <form:select class="form-control" id="trainingId" itemValue="id" itemLabel="allInfo" path="trainingDay"
                                 items="${trainings}"/><br>
                    <a href="#">Add training time</a>
                    <form:errors cssClass="error" path="trainingDay"></form:errors>
                </div>



                <%---------------------------------------------------------------------------------%>

                <%--<div class="form-group">--%>
                    <%--<label for="lastName">Surname:</label><br>--%>
                    <%--<form:input id="lastName" path="lastName" type="text" class="form-control"/><br>--%>
                    <%--<form:errors cssClass="error" path="lastName"></form:errors><br>--%>
                <%--</div>--%>

                <%--<div class="form-group">--%>
                    <%--<label for="email">Email:</label><br>--%>
                    <%--<form:input id="email" path="email" type="email" class="form-control"/><br>--%>
                    <%--<form:errors cssClass="error" path="email"></form:errors><br>--%>
                <%--</div>--%>

                <%--<div class="form-group">--%>
                    <%--<label for="phone">Phone:</label><br>--%>
                    <%--<form:input id="phone" path="phoneNumber" type="text" class="form-control"/><br>--%>
                    <%--<form:errors cssClass="error" path="phoneNumber"></form:errors><br>--%>
                <%--</div>--%>

                <%--<div class="form-group">--%>
                    <%--<label for="permission">Permission:</label><br>--%>
                    <%--<form:select class="form-control" path="permission">--%>
                        <%--<form:options/>--%>
                    <%--</form:select>--%>
                    <%--<form:errors cssClass="error" path="permission"></form:errors>--%>
                <%--</div>--%>

                <%--<div class="form-group">--%>
                    <%--<label for="groupsId">Groups:</label><br>--%>
                    <%--<form:select class="form-control" id="groupsId" itemValue="id" itemLabel="address" path="groups"--%>
                                 <%--items="${groups}"/><br>--%>
                    <%--<form:errors cssClass="error" path="groups"></form:errors>--%>
                <%--</div>--%>

                <input type="submit" value="Save">

            </div>
        </div>
    </div>

</form:form>
</body>
</html>
