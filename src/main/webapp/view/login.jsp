<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/login" var="loginUrl"/>
<!DOCTYPE html>
<html>
<head lang="pl">
    <title>Flat Organisation - Logowanie</title>
    <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
    <link rel="icon" href="images/favicon.ico" type="image/x-icon">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="assets/css/main.css" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<form action="${loginUrl}" method="post">
    <c:if test="${param.error != null}">
        <p>
            Nieprawidłowy login i hasło.
        </p>
    </c:if>
    <c:if test="${param.logout != null}">
        <p>
            Wylogowano.
        </p>
    </c:if>
    <p>
        <label for="username">Login</label>
        <input type="text" id="username" name="username"/>
    </p>
    <p>
        <label for="password">Hasło</label>
        <input type="password" id="password" name="password"/>
    </p>
    <input type="hidden"                        6
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
    <button type="submit" class="btn">Zaloguj</button>
</form>
</body>
</html>