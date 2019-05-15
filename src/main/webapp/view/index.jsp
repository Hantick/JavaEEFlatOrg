<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head lang="pl">
   <title>Flat Organisation</title>
   <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
   <link rel="icon" href="images/favicon.ico" type="image/x-icon">
   <meta name="viewport" content="width=device-width, initial-scale=1" />
   <link rel="stylesheet" href="assets/css/main.css" />
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
</head>
   
<body>

<!-- Header -->
<div sec:authorize="isAuthenticated()">
<header id="header">
   <div class="inner">
      <a href="/" class="logo"><strong>Flat Organisation App</strong></a>
      <nav id="nav">
         <a href="/">Strona Główna</a>

         <security:authorize access="! isAuthenticated()">
            <a href="register.html">Zarejestruj</a>
            <a href="/login">Zaloguj</a>
         </security:authorize>
         <security:authorize access="isAuthenticated()">
            <a href="/profile">Witaj, <strong><security:authentication property="name"/></strong></a>
            <a href="/logout">Wyloguj</a>
         </security:authorize>
      </nav>
      <a href="#navPanel" class="navPanelToggle"><span class="fa fa-bars"></span></a>
   </div>
</header>

   <!-- Banner -->
   <section id="banner">
      <div class="inner">
         <header>
            <security:authorize access="! isAuthenticated()">
               <h1>Witaj lokatorze w naszej aplikacji!</h1>
            </security:authorize>
            <security:authorize access="isAuthenticated()">
               <h1>Witaj <strong><security:authentication property="name"/></strong> w naszej aplikacji!</h1>
            </security:authorize>
         </header>

         <div class="flex ">

            <div>
               <span class="icon fas fa-home"></span>
               <h3>Prostota</h3>
               <p>Aplikacja łatwa w obsłudze</p>
            </div>

            <div>
               <span class="icon fas fa-user"></span>
               <h3>Organizacja</h3>
               <p>Ułatwia organizację życia współlokatorów</p>
            </div>

            <div>
               <span class="icon fas fa-tasks"></span>
               <h3>Użyteczność</h3>
               <p>Korzystaj z aplikacji codziennie!</p>
            </div>

         </div>

         <footer>
            <security:authorize access="!isAuthenticated()">
               <a href="#" class="button">Rozpocznij</a>
            </security:authorize>
         </footer>
      </div>
   </section>
</div>
<!-- Footer -->
<footer id="footer">
   <div class="inner">

      <div class="copyright">
         Projekt wykonywany przez Przemysław Szafrański oraz Beata Żurowska Images: <a href="https://unsplash.com">Unsplash</a>.
      </div>

   </div>
</footer>

<!-- Scripts -->
<script src="assets/js/skel.min.js"></script>
<script src="assets/js/util.js"></script>
<script src="assets/js/main.js"></script>

</body>
</html>