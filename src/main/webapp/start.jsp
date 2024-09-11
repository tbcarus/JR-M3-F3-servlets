<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.lang.String" %>
<!DOCTYPE html>
<html>
<head>
    <title>Quest Start</title>
</head>
<body>
<h1>
    Start JSP
</h1>

<h3>
    ${questList}
</h3>

<form action="start" method="POST">
    <fieldset>
        <legend>Выбор квеста</legend>
        <select name="questName">
            <c:forEach var="q" items="${questList}">
                <option value="${q}">${q}</option>
            </c:forEach>
        </select>
        <button type="submit">Выбрать</button>
    </fieldset>
</form>


<br/>
</body>
</html>