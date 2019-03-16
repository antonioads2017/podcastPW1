<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt">
<head>
    <meta http-equiv="Content-Type" charset="UTF-8" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
    <title>IFCast - Turmas virtuais</title>

    <!-- CSS  -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="../css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
    <link href="../css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
</head>
<body>
<%@ include file = "headerLogged.jsp" %>
<div class="row">
    <div class="col s12"><br>
        <h6>Suas turmas virtuais:</h6>
        <li class="divider"></li>

        <c:choose>
            <c:when test="${sessionScope.usuarioLogado.tipo == 'PROFESSOR'}">
                <%@ include file = "turmasVirtuaisProfessor.jsp" %>
            </c:when>
            <c:otherwise>
                <<%@ include file = "turmasVirtuaisAluno.jsp" %>
            </c:otherwise>
        </c:choose>


    </div>
</div>



<%@ include file = "footer.jsp" %>

<!--  Scripts-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/js/materialize.min.js">
</script>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

<script src="../js/materialize.js"></script>
<script src="../js/init.js"></script>
<c:if test="${turamCriada != null}">
    <script>
        $(document).ready(function(){

            M.toast({html: ${turmaCriada}}, 4000)

        });
    </script>
</c:if>
</body>
</html>
