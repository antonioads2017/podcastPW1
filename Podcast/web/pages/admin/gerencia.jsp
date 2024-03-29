<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <title>Gerencia</title>
    <meta http-equiv="Content-Type" charset="UTF-8" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
    <title>IFCast - Turmas virtuais</title>

    <style>
        <jsp:include page="../../css/style.css"/>
        <jsp:include page="../../css/materialize.css"/>
    </style>

    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
<%@ include file="../headerLogged.jsp" %>

<div class="row">
    <div class="col s12"></div>
    <div class="col s12 m4 l1"></div>
    <div class="col s12 m4 l10">
        <div class="card">
            <h4 align="center">Gêrencia de Usuários</h4>
            <div class="card-content">
                <table class="striped card-content">
                    <thead>
                    <th>Nome</th>
                    <th>Telefone</th>
                    <th>Data de Nascimento</th>
                    <th>E-mail</th>
                    <th>Nivel de Acesso</th>
                    </thead>
                    <tbody>
                    <c:forEach var="usuario" items="${usuarios}">
                        <c:if test="${usuario!=usuarioLogado}">
                            <tr>
                                <td>${usuario.nome}</td>
                                <td>${usuario.telefone}</td>
                                <td>${usuario.nascimento}</td>
                                <td>${usuario.email}</td>
                                <td>${usuario.nivelAcesso}</td>
                                <td><a href="/inicio?comando=UsuariosController&acao=deletar&emailUsuario=${usuario.email}"
                                       class="btn waves-effect waves-light red btn modal-trigger"/>Excluir</a>
                                </td>
                                <td><c:if test="${usuario.nivelAcesso=='USER'}">
                                    <a href="/inicio?comando=UsuariosController&acao=tornarAdmin&emailUsuario=${usuario.email}"
                                       class="btn waves-effect waves-light orange btn modal-trigger"/>Tornar ADMIN</a>
                                </c:if></td>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>
                    </tbody>


                </table>

                </div>
            </div>

        </div>
    </div>
</div>
</div>
<div class="col s12 m4 l1"></div>
</div>

<%@ include file="../footer.jsp" %>

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
