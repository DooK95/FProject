<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: adrian
  Date: 29.11.18
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="header.jsp"/>
    <title>Group List</title>
    <script>
        function confirmDelete(id, address) {
            if (confirm("Usunąć: " + address)) {
                window.location.href = "/groups/delete/" + id;
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
                    <td> Street</td>
                    <td> Training Days</td>
                    <td> Status</td>
                    <td> Coach</td>
                    <td> Size</td>
                    <td> Action</td>
                </tr>
                <c:forEach var="group" items="${groups}">
                    <tr>
                        <td>${group.address}</td>
                        <td>
                            <c:forEach var="trainingDay" items="${group.trainingDay}">
                                <span>${trainingDay}</span><br>
                            </c:forEach>
                        </td>
                        <td>${group.status}</td>
                        <td>
                            <c:forEach var="coaches" items="${group.coaches}">
                                <span>${coaches.fullName}</span><br>
                            </c:forEach>
                        </td>
                        <td>${group.groupSize}</td>
                        <td>
                            <a href="/groups/update/${group.id}" class="btn badge-success">Edit</a>
                            <a href="#" onclick="confirmDelete(${group.id}, '${group.address}')" )
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
