<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href='<c:url value="/css/bootstrap.min.css"/>' rel="stylesheet">
<link href='<c:url value="/css/main.css"/>' rel="stylesheet">

<nav class="navbar navbar-expand-sm justify-content-center bg-dark navbar-dark sticky-top">
    <ul class="navbar-nav">
        <li class="nav-item" active>
            <a class="nav-link" href="http://localhost:8080/coach/show">Coach</a>
        </li>
        <li class="nav-item" active>
            <a class="nav-link" href="http://localhost:8080/groups/show">Group</a>
        </li>
        <li class="nav-item" active>
            <a class="nav-link" href="http://localhost:8080/players/show">Player</a>
        </li>
    </ul>
</nav>
