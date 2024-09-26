<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Регистрация</title>
</head>

<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
<div class="container-sm bg-light py-4 text-center">
    <div class="row pb-2 mb-1 d-flex justify-content-center">
        <p class="fs-1"> Регистрация </p>
    </div>

    <form method="post" action="registration">
        <div class="row mb-0 d-flex justify-content-center">
            <p class="fs-3">Данные</p>
        </div>
        <div class="row mb-3">
            <div class="col-sm-3"></div>
            <div class="col-sm-6">
                <label for="email" class="form-label"> Логин:</label>
                <input id="email" class="form-control" type="text" name="login">
                <c:forEach var="lerr" items="${errors}">
                    <jsp:useBean id="lerr" type="ru.tbcarus.quest.model.ErrorMessage"/>
                    <c:if test="${lerr.name == 'login'}">
                        <div class="bg-danger-subtle">
                            <p>${lerr.message}</p>
                        </div>
                    </c:if>
                </c:forEach>
            </div>
            <div class="col-sm-3"></div>
        </div>

        <div class="row mb-3">
            <div class="col-sm-3"></div>
            <div class="col-sm-6">
                <label for="pass" class="form-label">Пароль:</label>
                <input id="pass" class="form-control" type="text" name="password">
                <c:forEach var="perr" items="${errors}">
                    <jsp:useBean id="perr" type="ru.tbcarus.quest.model.ErrorMessage"/>
                    <c:if test="${perr.name == 'password'}">
                        <div class="bg-danger-subtle">
                            <p>${perr.message}</p>
                        </div>
                    </c:if>
                </c:forEach>
            </div>
            <div class="col-sm-3"></div>
        </div>

        <div>
            <button class="btn btn-primary m-3" type="submit">Отправить</button>
        </div>
    </form>
</div>

</body>
</html>