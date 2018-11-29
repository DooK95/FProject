<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href='<c:url value="/css/bootstrap.min.css"/>' rel="stylesheet">
<link href='<c:url value="/css/main.css"/>' rel="stylesheet">

<div class="container">
    <div class="card">
        <div class="card-body">
            <table style="width:100%">
                <tr>
                    <th>Coach</th>
                    <th>Group</th>
                    <th>Players</th>
                </tr>
                <tr>
                    <td>
                        <a href="http://localhost:8080/coach/add">Add coach</a>
                    </td>
                    <td>
                        <a href="http://localhost:8080/groups/add">Add group</a>
                    </td>
                    <td><a href="http://localhost:8080/players/add">AddPlayer</a></td>
                </tr>
                <tr>
                    <td>
                        <a href="http://localhost:8080/coach/show">All coaches</a>
                    </td>
                    <td>
                        <a href="http://localhost:8080/groups/show">All groups</a>
                    </td>
                    <td><a href="http://localhost:8080/players/show">Show Players</a></td>
                </tr>
            </table>
        </div>
    </div>
</div>

