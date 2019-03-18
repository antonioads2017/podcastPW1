<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" charset="UTF-8" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
    <title>IFCast</title>

    <!-- CSS  -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="../css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
    <link href="../css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>

    <link href="../css/timeline.css" type="text/css" rel="stylesheet" media="screen,projection"/>

</head>
<body>
<%@ include file="headerLogged.jsp" %>

<div class="row">
    <div class="col s12"></div>
    <div class="col s12 m4 l2"></div>
    <div class="col s12 m4 l8">
        <div class="card">
            <audio id="myAudio" preload="auto">
                <source src="../audio/${podcast.audioPath}" type="audio/mpeg">
            </audio>
            <div class="card horizontal">
                <div class="card-image">
                    <img src="/img/cover.png" alt="music"
                         onClick="togglePlay()">
                </div>
                <div class="card-stacked" id="cabecalhoP">
                    <div class="card-content">
                        <div class="row valign-wrapper">
                            <div class="col s2" id="position"></div>
                            <div class="col s6 range-field valign-wrapper"><input id="seekbar" type="range" min="0"
                                                                                  max="0" step="1"
                                                                                  oninput="setSeek(this.value)"
                                                                                  onchange="setSeek(this.value)"></div>
                            <div class="col s2 center-align" id="total"></div>
                            <div class="col s2 center-align"><a class="" onClick="toggleMute()"><i
                                    class="material-icons teal-text lighten-1" id="Muted">volume_up</i></a></div>
                            <div class="col s3 range-field valign-wrapper"><input id="vol-control" type="range" min="0"
                                                                                  max="100" step="1"
                                                                                  oninput="SetVolume(this.value)"
                                                                                  onchange="SetVolume(this.value)">
                            </div>

                        </div>
                        <a class="btn-floating btn-large halfway-fab waves-effect waves-light red"
                           onClick="togglePlay()"><i class="material-icons" id="PausePlay">play_arrow</i></a>
                    </div>
                    <div class="card-action">
                        <p>Postado por: <b>${podcast.dono.nome}</b></p>
                    </div>
                </div>
            </div>
            <div class="card">
                <div class="card-image">

                </div>
                <div class="card-content">
                    <h5 class="">
                        ${podcast.titulo}
                    </h5>
                    <p>
                        ${podcast.descricao}
                        <%--"Bohemian Rhapsody" é uma canção composta em 1975 por Freddie Mercury, integrante da banda britânica Queen, e incluída no seu álbum A Night at the Opera. Esta canção não possui refrão.--%>
                    </p>
                </div>
                <div class="card-action">

                        <div class="col s12 card-title">Comentários:</div> <br>
                        <div class="card-content">
                            <ul class="collapsible">
                                <c:forEach var="comentario" items="${podcast.comentarios}">
                                <li>
                                    <div class="collapsible-header">
                                        <c:choose>
                                            <c:when test="${comentario.usuario.fotoPath == ''}">
                                                <img class="icone" src="http://www.wfmu.org/images/generic_avatar_300.png"/>
                                            </c:when>
                                            <c:otherwise>
                                                <img class="icone" src="/img/${comentario.usuario.fotoPath}"/>
                                            </c:otherwise>
                                        </c:choose>
                                         <p>${comentario.texto}</p>
                                        <span class="badge" ><b>${comentario.usuario.nome}</b></span>
                                       </div>
                                </li>
                                </c:forEach>
                            </ul>
                        </div>

                <div class="row">

                    <div class="col s12 m4 l2">
                        <c:choose>
                            <c:when test="${sessionScope.usuarioLogado.fotoPath == ''}">
                                <img class="icone" src="http://www.wfmu.org/images/generic_avatar_300.png"/>
                            </c:when>
                            <c:otherwise>
                                <img class="perfil responsive-img" src="/img/${sessionScope.usuarioLogado.fotoPath}"/>
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <form action="/inicio?comando=ComentarPodcastController&acao=comentar" method="POST">
                        <div class="col s12 m4 l8">

                            <div class="input-field col5 s5">
                                <input id="comentario" type="text" name="comentario">
                                <label for="comentario">Escreva um comentário...</label>

                            </div>

                            <input type="hidden" name="podcastPath" value="${podcast.audioPath}">
                        </div>
                        <div class="col s12 m4 l2">
                            <button class="btn-floating waves-effect waves-light" type="submit" name="action"><i
                                    class="material-icons right">chat</i>
                            </button>
                        </div>
                    </form>
                </div>
            </div>


        </div>
    </div>


    <script src="../js/podcast.js"></script>


</div>


<div class="col s12 m4 l2"></div>
</div>
</div>


<%@ include file="footer.jsp" %>


<!--  Scripts-->
<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script>
    $(document).ready(function () {
        $('.modal').modal();
    });
</script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/js/materialize.min.js">
</script>
<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="../js/materialize.js"></script>
<script src="../js/init.js"></script>
</body>
</html>
