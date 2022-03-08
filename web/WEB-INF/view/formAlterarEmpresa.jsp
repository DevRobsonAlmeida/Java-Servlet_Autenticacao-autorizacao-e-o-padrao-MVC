<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<c:url value="/entrada" var="linkServletNovaEmpresa"/>
<!DOCTYPE html>
<html>
    <head>
        <title>Editar Dados da Empresa</title>
    </head>
    <body>
        <form action="${linkServletNovaEmpresa}" method="post">
            Nome: <input type="text" name="nome" value="${empresa.nome}" />
            Data abertura :  <input type="text" name="data" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${empresa.dataAbertura}" />" />
            <input type="hidden" name="id" value="${empresa.id}" />
            <input type="hidden" name="acao" value="alteraEmprsa" />
            <input type="submit" value="Salvar"/>
        </form>
    </body>
</html>