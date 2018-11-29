<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: adrian
  Date: 29.11.18
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="header.jsp"/>
    <jsp:include page="playersHeader.jsp"/>
    <title>Players List</title>
    <script>
        function confirmDelete(id, firstName) {
            if (confirm("Usunąć: " + firstName)) {
                window.location.href = "/players/delete/" + id;
            }
        }
    </script>
</head>
<body>

<div class="container" style="max-width: 80%">
    <div class="card">
        <div class="card-body">
            <h3>Players list:</h3>
            <table class="table table-hover">
                <tr>
                    <td> Name</td>
                    <td> Phone</td>
                    <td> Email</td>
                    <td> Year</td>
                    <td> Street</td>
                    <td> Trainings in week</td>
                    <td> Status</td>
                    <td> Group</td>
                    <td> Action</td>
                </tr>
                <c:forEach var="player" items="${players}">
                    <tr>
                        <td>${player.fullName}</td>
                        <td>${player.phoneNumber}</td>
                        <td>${player.email}</td>
                        <td>${player.birthYear}</td>
                        <td>${player.fullAddress}</td>
                        <td>${player.numberOfTrainings}</td>
                        <td>${player.status}</td>
                        <td>${player.group.address}</td>

                        <td>
                            <a href="/players/update/${player.id}" class="btn badge-success">Edit</a>
                            <a href="#" onclick="confirmDelete(${player.id}, '${player.secondName}')" )
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
