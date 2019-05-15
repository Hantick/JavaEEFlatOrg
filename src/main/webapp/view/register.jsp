<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<head lang="pl">
    <title>Flat Organisation - Rejestracja</title>
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
            <a href="/login">Zaloguj</a>
        </nav>
        <a href="#navPanel" class="navPanelToggle"><span class="fa fa-bars"></span></a>
    </div>
</header>
<!-- Banner -->
<section id="banner" style="padding: 5em 0 5em 0">
    <div class="inner">
        <header>
            <div th:fragment="content">
<div class="container">


    <form:form method="POST" modelAttribute="residentForm" class="form-signin">
        <h1 class="form-signin-heading">Zarejestruj się</h1>

        <spring:bind path="login">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="login" class="form-control" placeholder="Login"
                            autofocus="true"></form:input>
                <form:errors path="login"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="name">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="name" class="form-control" placeholder="Imię"
                            autofocus="true"></form:input>
                <form:errors path="name"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="surname">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="surname" class="form-control" placeholder="Nazwisko"
                            autofocus="true"></form:input>
                <form:errors path="surname"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="phone_number">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="number" path="phone_number" class="form-control" placeholder="Numer telefonu"
                            autofocus="true"></form:input>
                <form:errors path="phone_number"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="password">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="password" class="form-control" placeholder="Hasło"></form:input>
                <form:errors path="password"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="passwordConfirm">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="passwordConfirm" class="form-control"
                            placeholder="Potwierdź hasło"></form:input>
                <form:errors path="passwordConfirm"></form:errors>
            </div>
        </spring:bind>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </form:form>

</div>
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>