<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Вход</title>
</head>

<body>
<div>
    <h1>
        Login
    </h1>
</div>
<form method="post" action="login">
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
            <button type="submit">Login</button>
        </div>
    </fieldset>
</form>


</body>
</html>