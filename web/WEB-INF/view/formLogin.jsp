<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<c:url value="/entrada" var="linkLoginServlet" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <form action="${linkLoginServlet}" method="post">
            <p>Login: <input type="text" name="login" /></p>
            <p>Senha: <input type="password" name="senha" /></p>
            <input type="hidden" name="acao" value="Login" />
            
            <input type="submit" value="Logar" />
        </form>
    </body>
</html>
