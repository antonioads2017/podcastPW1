<%--
  Created by IntelliJ IDEA.
  User: eduardo
  Date: 3/16/19
  Time: 3:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta http-equiv="Content-Type" charset="UTF-8" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
    <title>IFCast - Editar dados</title>

    <!-- CSS  -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="../css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
    <link href="../css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
</head>
<body>
<%@ include file="headerLogged.jsp" %>
<div class="row">
    <div class="col s12"></div>
    <div class="col s12 m4 l2"></div>
    <div class="col s12 m4 l8">
        <div class="card">

            <div class="card-content">
                <div>
                    <c:choose>
                        <c:when test="${sessionScope.usuarioLogado.fotoPath == ''}">
                            <img class="perfil" src="http://www.wfmu.org/images/generic_avatar_300.png"/>
                        </c:when>
                        <c:otherwise>
                            <img class="perfil" src="/img/${sessionScope.usuarioLogado.fotoPath}"/>
                        </c:otherwise>
                    </c:choose>
                </div>
                <!-- Modal Trigger -->
                <a class="btn-large waves-effect waves-light orange btn modal-trigger" href="#modal3">Mudar foto</a><br><br>


                <center>
                    <div class="row">

                        <!-- Modal Structure -->
                        <div id="modal3" class="modal">
                            <div class="modal-content">
                                <center>
                                    <div class="row">
                                        <form class="s4" action="/inicio?comando=UsuariosController&acao=salvarImagem" method="POST" enctype="multipart/form-data">
                                            <div>
                                                <div class="file-field input-field">
                                                    <div class="btn">
                                                        <span>Escolher foto</span>
                                                        <input type="file" name="foto"/>
                                                    </div>


                                                    <div class="file-path-wrapper">
                                                        <input class="file-path validate"
                                                               type="text"
                                                               placeholder="Upload file"/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="bottom">
                                                <button class="btn"> Enviar imagem</button>
                                            </div>
                                        </form>
                                    </div>
                                </center>
                            </div>
                        </div>
                    </div>
                    <form class="col10 s10"
                          action="/inicio?comando=UsuariosController&acao=atualizar"
                          method="POST">
                        <div class="row">

                            <div class="row">


                                <div class="input-field col10 s10">
                                    <input id="name" type="text" class="validate"
                                           name="nome"
                                           value="${sessionScope.usuarioLogado.nome}"
                                           maxlength="40" required>
                                    <label for="name">Nome</label></div>
                                <div class="input-field col10 s10">
                                    <input id="email" type="email" class="validate"
                                           name="email"
                                           value="${sessionScope.usuarioLogado.email}"
                                           required>
                                    <label for="email">E-mail</label></div>
                                <div class="input-field col10 s10">
                                    <input id="password" type="password"
                                           class="validate" name="senha" value=""
                                           minlength="6" required>
                                    <label for="password">Senha</label></div>
                                <div class="input-field col10 s10">
                                    <input id="cellphone" type="text" class="validate"
                                           name="telefone"
                                           value="${sessionScope.usuarioLogado.telefone}">
                                    <label for="cellphone">Telefone</label>
                                </div>
                                <div class="input-field col10 s10">
                                    <input id="date" type="date" class="validate"
                                           name="nascimento"
                                           value="${sessionScope.usuarioLogado.nascimento}"
                                           required>
                                    <label for="date">Data de Nascimento</label>
                                </div>


                                <button class="btn waves-effect waves-light"
                                        type="submit" name="action">Editar
                                    <i class="material-icons right">cloud</i>
                                </button>
                            </div>

                        </div>
                    </form>
                </center>
            </div>
        </div>
    </div>
</div>

<div class="col s12 m4 l2"></div>

<%@ include file="footer.jsp" %>
</body>
</html>


<!-- Scripts-->
<script type="text/javascript"
        src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/js/materialize.min.js">
</script>
<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>

<script src="../js/materialize.js"></script>
<script src="../js/init.js"></script>

</body>
</html>

