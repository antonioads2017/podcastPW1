<%--
  Created by IntelliJ IDEA.
  User: mailson
  Date: 16/03/19
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head lang="pt-br">
    <meta http-equiv="Content-Type" charset="UTF-8" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
    <title>IFCast - ${turma.nome}</title>

    <style>
        <jsp:include page="../css/materialize.css" />
        <jsp:include page="../css/style.css" />
        <jsp:include page="../css/timeline.css" />
    </style>

    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

</head>
    <body>
        <%@ include file = "headerLogged.jsp" %>


        <div class="row">
            <div class="col s1"></div>
            <div class="col s8">
                <div class="card horizontal left-align">
                    <div class="card-title">
                        <h4>${turma.nome}</h4>
                    </div>
                    <div class="card-stacked">
                        <div class="card-content">
                            ${turma.descricao}
                        </div>
                        <div class="card-action">
                            <c:if test="${sessionScope.usuarioLogado.tipo == 'ALUNO'}">
                                <a class="waves-effect waves-light btn-large"><i class="material-icons right">close</i>Sair da turma</a>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col s3">
                <span class="center-align white-text">Criado por: ${turma.criador.nome}</span>
            </div>
        </div>
        <div class="row">
            <div class="card col s12">
                <div class="card-content">
                    <div class="card-title">
                        <h4>Podcasts</h4>
                    </div>
                    <div class="col s8">
                        <ul>
                            <c:forEach var="podcast" items="${turma.podcasts}">
                                <li>
                                    <div class="col s6 card">
                                        <div class="card-content">
                                            <span class="card-title grey-text text-darken-4">${podcast.titulo}<span ><i class="material-icons right">info</i></span></span>
                                            <p>Categoria: ${podcast.categoria}</p>
                                            <p>Dono: ${podcast.dono.nome}</p>
                                            <a class="btn-floating halfway-fab waves-effect waves-light red" href="/inicio?comando=PodcastController&acao=buscar&referencia=${podcast.audioPath}"><i class="material-icons">play_arrow</i></a>
                                        </div>
                                    </div>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                    <div class="col s4">
                        <div class="card">
                            <%--<h5 class="card-title">Participantes</h5>--%>
                            <div class="card-content">
                                <ul class="collection">
                                    <c:forEach var="aluno" items="${turma.participantes}">
                                        <li class="collection-item avatar">
                                            <c:choose>
                                                <c:when test="${aluno.fotoPath == ''}">
                                                    <img src="http://www.wfmu.org/images/generic_avatar_300.png" alt="" class="circle"/>
                                                </c:when>
                                                <c:otherwise>
                                                    <img src="/img/${aluno.fotoPath}" alt="" class="circle">
                                                </c:otherwise>
                                            </c:choose>
                                            <span class="title">${aluno.nome}</span>
                                            <p>${aluno.email}</p>
                                            <c:if test="${sessionScope.usuarioLogado.tipo == 'PROFESSOR'}">
                                                <a href="/inicio?comando=TurmaVirtualController&acao=removerMembro&emailAluno=${aluno.email}&nomeTurma=${turma.nome}"> <i class="material-icons">close</i> </a>
                                            </c:if>
                                            <a href="/inicio?comando=UsuariosController&acao=buscar&emailUsuario=${aluno.email}" class="secondary-content"><i class="material-icons">info_outline</i></a>
                                        </li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <%@ include file = "footer.jsp" %>
        <!--  Scripts-->
        <script type="text/javascript"
                src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/js/materialize.min.js">
        </script>
        <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>

        <script src="../js/materialize.js"></script>
        <script src="../js/init.js"></script>
    </body>
</html>
