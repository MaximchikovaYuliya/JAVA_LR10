<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 26.05.2019
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <form action="Servlet1">
    <input type="submit" value="Task1">
  </form>

  <form action="Servlet2" method="post">
    <p>AUTHORIZATION</p>
    <fieldset>
      <p><label for="login">Login </label><input type="text" id="login" name="login"></p>
      <p><label for="password">Password </label><input type="password" id="password" name="password"></p>
      <p>
        <input type="submit" value="Sing In">
        <a href="registration.jsp">registration</a>
      </p>
      <a href="SecurePage.jsp">Secure Page</a>
    </fieldset>
  </form>

  <form action="Servlet5" method="get">
    <p>TASK 6</p>
    <fieldset>
      <input type="submit" value="Go to servlet">
    </fieldset>
  </form>

  <form action="Servlet6" method="get">
    <p>TASK 7</p>
    <fieldset>
      <p><label for="text">Text </label><input type="text" id="text" name="text"></p>
      <input type="submit" value="Go to servlet">
    </fieldset>
  </form>

  </body>
</html>
