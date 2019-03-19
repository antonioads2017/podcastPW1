<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta http-equiv="Content-Type" charset="ISO-8859-1" content="text/html" charset="ISO-8859-1"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
    <title>IFCast - Turmas virtuais</title>

    <style>
        <jsp:include page="../css/materialize.css" />
        <jsp:include page="../css/style.css" />
        <jsp:include page="../css/timeline.css" />
    </style>

    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

</head>
<body>
<%@ include file="headerLogged.jsp" %>

<div class="row">

    <div class="col s12"></div>
    <div class="col s12 m4 l2"></div>
    <div class="col s12 m4 l8">
        <p>
            <c:choose>
                <c:when test="${sessionScope.usuarioLogado.tipo == 'PROFESSOR'}">
                    <%@ include file="turmasVirtuaisProfessor.jsp" %>
                </c:when>
                <c:otherwise>
                    <%@ include file="turmasVirtuaisAluno.jsp" %>
                </c:otherwise>
            </c:choose>
        </p>
    </div>
    <div class="col s12 m4 l2"></div>

</div>


<%@ include file="footer.jsp" %>

<!--  Scripts-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/js/materialize.min.js">
</script>


<script src="../js/materialize.js"></script>
<script src="../js/init.js"></script>
<c:if test="${msg != null}">
    <script>
        $(document).ready(function () {

            M.toast({html: ${msg}}, 4000)

        });
    </script>
</c:if>
<c:if test="${sessionScope.usuarioLogado.tipo == 'PROFESSOR'}">
    <script>
        $(document).ready(function () {
            $('select').formSelect();
            $('.sidenav').sidenav();
        });
    </script>
</c:if>
</body>
</html>
