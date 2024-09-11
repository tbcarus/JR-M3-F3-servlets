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
        <div>
            <label>Пароль:
                <input type="text" name="password">
            </label>
        </div>
        <div>
            <button type="submit">Отправить</button>
        </div>
    </fieldset>
</form>


</body>
</html>