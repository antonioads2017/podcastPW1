<%--
  Created by IntelliJ IDEA.
  User: mailson
  Date: 16/03/19
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head lang="pt">
    <meta http-equiv="Content-Type" charset="UTF-8" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
    <title>IFCast - ${turma.nome}</title>

    <!-- CSS  -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="../css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
    <link href="../css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
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
                <span class="center-align">Criado por: ${turma.criador.nome}</span>
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
                                            <span class="card-title grey-text text-darken-4">Aula 02<span ><i class="material-icons right">info</i></span></span>
                                            <p>Categoria: Escolar ${podcast.categoria}</p>
                                            <p>Dono: Mailson ${podcast.dono.nome}</p>
                                            <a class="btn-floating halfway-fab waves-effect waves-light red" href="moduloPodcast.jsp"><i class="material-icons">play_arrow</i></a>
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
                                    <li class="collection-item avatar">
                                        <img src="${pageContext.servletContext.IMG_DIR+usuario.foto}" alt="" class="circle">
                                        <span class="title">Title</span>
                                        <p>First Line <br>
                                            Second Line
                                        </p>
                                        <a href="#!" class="secondary-content"><i class="material-icons">grade</i></a>
                                    </li>
                                    <li class="collection-item avatar">
                                        <i class="material-icons circle">folder</i>
                                        <span class="title">Title</span>
                                        <p>First Line <br>
                                            Second Line
                                        </p>
                                     asdasdqw   <a href="#!" class="secondary-content"><i class="material-icons">grade</i></a>
                                    </li>
                                    <li class="collection-item avatar">
                                        <i class="material-icons circle green">insert_chart</i>
                                        <span class="title">Title</span>
                                        <p>First Line <br>
                                            Second Line
                                        </p>
                                        <a href="#!" class="secondary-content"><i class="material-icons">grade</i></a>
              e                      </li>
                                    <li class="collection-item avatar">
                                        <i class="material-icons circle red">play_arrow</i>
                                        <span class="title">Title</span>
                                        <p>First Line <br>
                                            Second Line
                                        </p>
                                        <a href="#!" class="secondary-content"><i class="material-icons">grade</i></a>
                                    </li>
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
