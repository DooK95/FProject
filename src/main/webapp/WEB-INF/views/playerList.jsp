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

<div class="container">
    <div class="card">
        <div class="card-body">
            <table class="table table-hover">
                <tr>
                    <td> Name</td>
                    <td> Surname</td>
                    <td> Phone</td>
                    <td> Email</td>
                    <td> Year</td>
                    <td> Street</td>
                    <td> Code</td>
                    <td> City</td>
                    <td> Trainings in week</td>
                    <td> Status</td>
                    <td> Group</td>
                    <td> Action</td>
                </tr>
                <c:forEach var="player" items="${players}">
                    <tr>
                        <td>${player.firstName}</td>
                        <td>${player.secondName}</td>
                        <td>${player.phoneNumber}</td>
                        <td>${player.email}</td>
                        <td>${player.birthYear}</td>
                        <td>${player.address}</td>
                        <td>${player.code_address}</td>
                        <td>${player.city}</td>
                        <td>${player.numberOfTrainings}</td>
                        <td>${player.status}</td>
                        <td>${player.group}</td>

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
