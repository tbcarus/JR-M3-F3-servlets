<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.lang.String" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Quest Start</title>
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>

<div class="container-sm bg-light py-4 text-center">
    <div class="row pb-2 mb-1 d-flex justify-content-center">
        <p class="fs-1">Выбор квеста</p>
    </div>
<form action="start" method="POST">
    <div class="mb-3">
        <select name="questName">
            <c:forEach var="q" items="${questList}">
                <option value="${q}">${q}</option>
            </c:forEach>
        </select>
    </div>
    <div>
        <button class="btn btn-primary m-3" type="submit">Выбрать</button>
    </div>
</form>
</div>


<br/>
</body>
</html>