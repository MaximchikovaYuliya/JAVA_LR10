<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 27.05.2019
  Time: 9:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="Servlet3" method="post">
        <p>REGISTRATION</p>
        <fieldset>
            <p><label for="login">Login </label><input type="text" id="login" name="login"></p>
            <p><label for="password">Password </label><input type="password" id="password" name="password"></p>
            <p>
                <input type="submit" value="Sing Up">
            </p>
            <a href="SecurePage.jsp">Secure Page</a>
        </fieldset>
    </form>
</body>
</html>
