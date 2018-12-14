<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: adrian
  Date: 29.11.18
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="header.jsp"/>
    <jsp:include page="playersHeader.jsp"/>
    <title>Add Player</title>

</head>
<body>

<%--@elvariable id="player" type="java"--%>
<form:form method="post" modelAttribute="player">
    <div class="container" style="max-width: 80%">
        <div class="card">
            <div class="card-body">
                <h3>Add Player:</h3>
                <div class="form-group">
                    <label for="firstName">Name:</label><br>
                    <form:input id="firstName" path="firstName" type="text" class="form-control"/>
                    <form:errors cssClass="error" path="firstName"></form:errors>
                </div>

                <div class="form-group">
                    <label for="lastName">Surname:</label><br>
                    <form:input id="lastName" path="secondName" type="text" class="form-control"/>
                    <form:errors cssClass="error" path="secondName"></form:errors>
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
                </div>

                <div class="form-group">
                    <label for="year">Year of Birth:</label><br>
                    <form:input id="year" path="birthYear" type="text" class="form-control"/>
                    <form:errors cssClass="error" path="birthYear"></form:errors>
                </div>

                <div class="form-group">
                    <label for="street">Street:</label><br>
                    <form:input id="street" path="address" type="text" class="form-control"/>
                    <form:errors cssClass="error" path="address"></form:errors>
                </div>

                <div class="form-group">
                    <label for="code">Code:</label><br>
                    <form:input id="code" path="code_address" type="text" class="form-control"/>
                    <form:errors cssClass="error" path="code_address"></form:errors>
                </div>

                <div class="form-group">
                    <label for="cityId">City:</label><br>
                    <form:input id="cityId" path="city" type="text" class="form-control"/>
                    <form:errors cssClass="error" path="city"></form:errors>
                </div>

                <div class="form-group">
                    <label for="numberOfTrainings">Number of trainings a week:</label><br>
                    <form:select class="form-control" path="numberOfTrainings">
                        <form:options/>
                    </form:select>
                    <form:errors cssClass="error" path="numberOfTrainings"></form:errors>
                </div>


                    <%--<c:if test="${fn:contains(pageContext.request.requestURI, 'update')}">--%>
                    <%--<div class="form-group">--%>
                    <%--<label for="status">Status:</label><br>--%>
                    <%--<form:select class="form-control" path="status" multiple="false">--%>
                    <%--<form:options/>--%>
                    <%--</form:select>--%>
                    <%--<form:errors cssClass="error" path="status"></form:errors>--%>
                    <%--</div>--%>
                    <%--</c:if>--%>
                <div class="form-group">
                    <label for="status">Status:</label><br>
                    <form:select class="form-control" path="status" multiple="false">
                        <form:options/>
                    </form:select>
                    <form:errors cssClass="error" path="status"></form:errors>
                </div>


                <div class="form-group">
                    <label for="groupsId">Group:</label><br>
                    <form:select multiple="false" class="form-control" id="groupsId" itemValue="id" itemLabel="address"
                                 path="group"
                                 items="${groups}"/><br>
                    <form:errors cssClass="error" path="group"></form:errors>
                </div>

                <input type="submit" value="Save">

            </div>
        </div>
    </div>

</form:form>
</body>
</html>
