<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Регистрация</title>
</head>

<body>
<div>
    <h1>
        Регистрация
    </h1>
</div>
<form method="post" action="registration">
    <fieldset>
        <legend>Данные</legend>
        <div>

            <label> Логин:
                <input type="text" name="login">
            </label>
        </div>

        <c:forEach var="lerr" items="${errors}">
            <jsp:useBean id="lerr" type="ru.tbcarus.quest.model.ErrorMessage"/>
            <c:if test="${lerr.name == 'login'}">
                <p style="color: red">${lerr.message}</p>
            </c:if>
        </c:forEach>
        <div>
            <label>Пароль:
                <input type="text" name="password">
            </label>
        </div>
        <c:forEach var="perr" items="${errors}">
            <jsp:useBean id="perr" type="ru.tbcarus.quest.model.ErrorMessage"/>
            <c:if test="${perr.name == 'password'}">
                <p style="color: red">${perr.message}</p>
            </c:if>
        </c:forEach>
        <div>
            <button type="submit">Отправить</button>
        </div>
    </fieldset>
</form>


</body>
</html>