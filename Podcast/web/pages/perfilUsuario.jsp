<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt">
<head>

    <meta http-equiv=”Content-Type” content=”text/html; charset=utf-8″>

    <meta http-equiv=”Content-Type” content=”text/html; charset=iso-8859-1″>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
    <title>IFCast - Início</title>

    <!-- CSS  -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="../css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
    <link href="/css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>

    <link href="../css/timeline.css" type="text/css" rel="stylesheet" media="screen,projection"/>
    <style>
        .perfil {
            width: 150px;
            height: 150px;
            border-radius: 50%;
        }
    </style>
</head>
<body>

<%@ include file="headerLogged.jsp" %>
<div class="row">
    <div class="col s12"></div>
    <div class="col s12 m4 l2"></div>
    <div class="col s12 m4 l8">
        <div class="card">

            <div class="card-content">
                <center>
                    <c:choose>
                        <c:when test="${sessionScope.usuarioLogado.fotoPath == ''}">
                            <img class="perfil" src="http://www.wfmu.org/images/generic_avatar_300.png"/>
                        </c:when>
                        <c:otherwise>
                            <img class="perfil" src="/img/${sessionScope.usuarioLogado.fotoPath}"/>
                        </c:otherwise>
                    </c:choose>

                    <h4>${sessionScope.usuarioLogado.nome} </h4>

                    <p>${sessionScope.usuarioLogado.tipo} / ${sessionScope.usuarioLogado.nivelAcesso}</p>
                </center>


                <div class=" card-tabs">
                    <ul class="tabs tabs-fixed-width">
                        <li class="tab"><a href="#dados">Meus dados <i class="small material-icons">person</i></a></li>
                        <li class="tab"><a href="#settings">Configurações<i
                                class="small material-icons">settings</i></a>
                        </li>
                    </ul>
                </div>
                <div class="card-content grey lighten-4">
                    <div id="dados">
                        <h4>Detalhes da conta:</h4>
                        <p><b>Nome completo:</b> ${sessionScope.usuarioLogado.nome}</p>
                        <p><b>Telefone:</b> ${sessionScope.usuarioLogado.telefone} </p>
                        <p><b>E-mail: </b>${sessionScope.usuarioLogado.email} </p>
                        <p><b>Nascimento:</b> ${sessionScope.usuarioLogado.nascimento} </p>
                    </div>
                    <div id="settings"><h4>Configuração da conta:</h4>
                        <a href="/pages/editarUsuario.jsp">Editar dados</a><br>
                        <a class="modal-trigger" href="#md1" >Desativar conta</a><br>
                        <c:if test="${sessionScope.usuarioLogado.nivelAcesso=='ADMIN'}">
                            <a href="admin/gerencia.jsp">Gêrencia de Usuários</a></c:if></div>
                </div>
            </div>

            <div id="md1" class="modal">
                <div class="modal-content">
                    <h4>Porfavor confirme</h4>
                    <p>Todos os seus dados, podcasts ou turmas virtuais cadastrados no sistema também serão excluídos!
                        </p>
                    <p>Deseja continuar com esta ação?</p>
                </div>
                <div class="modal-footer">
                    <a href="#!" class="modal-close btn">Não</a>
                    <a href="/inicio?comando=UsuariosController&acao=desativarConta&emailUsuario=${sessionScope.usuarioLogado.email}"
                       class="waves-effect waves-green red btn-flat center-align" id="md1_YesBtn">Sim</a>
                </div>
            </div>

        </div>
    </div>
</div>
</div>
<div class="col s12 m4 l2"></div>
</div>


<%@ include file="footer.jsp" %>

<!--  Scripts-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/js/materialize.min.js">
</script>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="../js/materialize.js"></script>
<script src="../js/init.js"></script>
<c:if test="${dadosAtualizados != null}">
    <script>
        $(document).ready(function () {

            M.toast({html: '${dadosAtualizados}'}, 4000);

        });
    </script>
</c:if>
</body>
</html>
