<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>

    <meta http-equiv=”Content-Type” charset="UTF-8" content=”text/html;″>

    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
    <title>IFCast - Início</title>

    <style>
        <jsp:include page="../css/materialize.css" />
        <jsp:include page="../css/style.css" />
        <jsp:include page="../css/timeline.css" />

        .circle {
            border-radius: 50%;
        }

    </style>

    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

</head>
<body>

<%@ include file="headerLogged.jsp" %>
<div class="timeline">
    <div class="row">
        <%--<c:choose>--%>
            <%--<c:when test="${podcasts.size>0}">--%>
                <c:forEach var="podcast" items="${podcasts}">
                <div class="col s6 m3">
                    <div class="card podcast">
                        <div class="card-image">
                            <img src="/img/cover.png" class="capa">
                            <span class="card-title">${podcast.titulo}</span>
                            <a class="btn-floating halfway-fab waves-effect waves-light red" href="/inicio?comando=PodcastController&acao=buscar&referencia=${podcast.audioPath}"><i
                                    class="material-icons">play_arrow</i></a>
                        </div>
                        <div class="card-content">
                            <p class="autor"><b> Postado por ${podcast.dono.nome}
                            </b></p><br>
                            <p class="descricao "> ${podcast.descricao}</p>
                        </div>
                    </div>
                </div>
            </c:forEach>
            <%--</c:when>--%>
            <%--<c:otherwise>--%>
            <%--<div class="col s12"></div>--%>
            <%--<div class="col s12 m4 l2"></div>--%>
            <%--<div class="col s12 m4 l8">--%>
                <%--<div class="card">--%>
                    <%--<div class="card-title">--%>
                        <%--<p>Ainda não existem podcasts cadastrados!</p></div>--%>
                    <%--</div>--%>
<%--<div class="col s12 m4 l2"></div>--%>
            <%--</c:otherwise>--%>
        <%--</c:choose>--%>

    </div>


</div>


<%@ include file="footer.jsp" %>

<!--  Scripts-->
<script type="text/javascript"
        src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/js/materialize.min.js">
</script>
<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="../js/materialize.js"></script>
<script src="../js/init.js"></script>

<script>
    $(document).ready(function () {
        $('.modal').modal();
    });
</script>
</body>
</html>
