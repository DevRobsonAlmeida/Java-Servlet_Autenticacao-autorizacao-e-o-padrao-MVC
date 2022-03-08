<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<c:url value="/entrada" var="linkServletNovaEmpresa"/>
<!DOCTYPE html>
<html>
    <head>
        <title>Cadastro da Empresa</title>
    </head>
    <body>
        <form action="${linkServletNovaEmpresa}" method="post">

            Nome: <input type="text" name="nome"  />
            Data abertura : <input type="text" name="data" />
            <input type="hidden" name="acao" value="novaEmpresa" />

            <input type="submit" value="Salvar"/>
        </form>
    </body>
</html> 