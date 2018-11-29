<%--
  Created by IntelliJ IDEA.
  User: adrian
  Date: 27.11.18
  Time: 13:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="header.jsp"/>
    <jsp:include page="coachHeader.jsp"/>
    <title>Coach List</title>
    <script>
        function confirmDelete(id, firstName) {
            if (confirm("Usunąć: " + firstName)) {
                window.location.href = "/coach/delete/" + id;
            }
        }
    </script>
</head>
<body>

<div class="container" style="max-width: 80%">
    <div class="card">
        <div class="card-body">
            <h3>Coachs list:</h3>
            <table class="table table-hover">
                <tr>
                    <td> Name</td>
                    <td> Surname</td>
                    <td> Email</td>
                    <td> Phone</td>
                    <td> Permission</td>
                    <td> Groups</td>
                    <td> Action</td>
                </tr>
                <c:forEach var="coach" items="${coaches}">
                    <tr>
                        <td>${coach.firstName}</td>
                        <td>${coach.lastName}</td>
                        <td>${coach.email}</td>
                        <td>${coach.phoneNumber}</td>
                        <td>${coach.permission}</td>
                        <td>
                            <c:forEach var="group" items="${coach.groups}">
                                <span>${group.address}</span><br>
                            </c:forEach>
                        </td>
                        <td>
                            <a href="/coach/update/${coach.id}" class="btn badge-success">Edit</a>
                            <a href="#" onclick="confirmDelete(${coach.id}, '${coach.firstName}')" )
                               class="btn badge-danger">Delete</a>
                        </td>
                    </tr>
                </c:forEach>

            </table>

        </div>
    </div>
</div>
</body>
</html>
