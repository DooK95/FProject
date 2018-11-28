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
                    <td>AddGroup</td>
                    <td>AddPlayer</td>
                </tr>
                <tr>
                    <td>
                        <a href="http://localhost:8080/coach/show">All coaches</a>
                    </td>
                    <td>Show Group</td>
                    <td>Show Players</td>
                </tr>
            </table>
        </div>
    </div>
</div>

