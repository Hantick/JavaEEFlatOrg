<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/login" var="loginUrl"/>
<!DOCTYPE html>
<html xmlns:th="https://www.thymeleaf.org">
<head lang="pl">
    <title>Flat Organisation - Logowanie</title>
    <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
    <link rel="icon" href="images/favicon.ico" type="image/x-icon">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="assets/css/main.css" />
    <link rel="stylesheet" href="assets/css/login.css" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<!-- Header -->
<header id="header">
    <div class="inner">
        <a href="/" class="logo"><strong>Przemysław Szafrański Beata Żurowska</strong></a>
        <nav id="nav">
            <a href="/">Strona Główna</a>
            <a href="register.html">Zarejestruj</a>
            <a href="/login">Zaloguj</a>
        </nav>
        <a href="#navPanel" class="navPanelToggle"><span class="fa fa-bars"></span></a>
    </div>
</header>
<!-- Banner -->
<section id="banner" style="padding: 5em 0 5em 0">
    <div class="inner">
        <header>
            <h1>Zaloguj się</h1>
            <div th:fragment="content">
                <form action="${loginUrl}" method="post">
                    <fieldset>
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
                            <label for="username" id="labelLogin">Login</label>
                            <input type="text" id="username" name="username" placeholder="login"/>
                        </p>
                        <p>
                            <label for="password" id="labelHaslo">Hasło</label>
                            <input type="password" id="password" name="password" placeholder="haslo"/>
                        </p>
                        <input type="hidden"
                               name="${_csrf.parameterName}"
                               value="${_csrf.token}"/>
                        <button type="submit" class="btn">Zaloguj</button>
                    </fieldset>
                </form>
            </div>
        </header>
    </div>
</section>
<!-- Footer -->
<footer id="footer" style="padding: 8em ">
    <div class="inner">
        <div class="copyright">
            &copy; Beata Żurowska Przemysłam Szafrański. Untitled. Design: <a href="https://templated.co">TEMPLATED</a>. Images: <a href="https://unsplash.com">Unsplash</a>.
        </div>
    </div>
</footer>

<script src="assets/js/skel.min.js"></script>
<script src="assets/js/util.js"></script>
<script src="assets/js/main.js"></script>
</body>
</html>