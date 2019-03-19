<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-br">
<head><title>IFCast - Criar turma </title>
    <meta http-equiv="Content-Type" charset="ISO-8859-1" content="text/html; charset=ISO-8859-1"/>
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
        <div class="card-panel">
            <div class="row">
                <form class="col s12" action="/inicio?comando=TurmaVirtualController&acao=criar" method="POST">
                    <div class="row">
                        <div class="input-field col s12">
                            <input name="nomeTurma" id="nome" type="text" class="validate" minlength="5" required>
                            <label for="nome">Nome</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12">
                            <input name="descricao" id="descricao" type="text" class="validate" minlength="10" required>
                            <label for="descricao">Descrição</label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col s6">
                            <div class="input-field col s8">
                                <select class="icons" id="select">
                                    <option value="" disabled selected>Selecione um aluno</option>
                                    <c:forEach var="aluno" items="${alunos}">
                                        <option value="${aluno.email}" data-icon="#">${aluno.email}</option>
                                    </c:forEach>
                                </select>
                                <label>Materialize Select</label>
                            </div>
                            <div class="input-field col s4">
                                <div id="membros">
                                    <a class="btn-floating btn-large waves-effect waves-light red"><i
                                            class="material-icons" onclick="adicionaAluno()">add</i></a> Adicionar membros
                                </div>
                            </div>
                        </div>
                        <div class="col s6">
                            <div class="col s12">
                                <div class="card blue-grey darken-1">
                                    <div class="card-content white-text">
                                        <span class="card-title">Alunos adicionados</span>
                                        <ul class="collection with-header" id="listaAlunos" >
                                            <%--<li class="collection-item black-text">Alvin<a class="secondary-content"><i class="material-icons">send</i></a></li>--%>
                                        </ul>

                                    </div>
                                    <div class="card-action">
                                        <button class="btn waves-effect waves-light right" type="submit" name="action">Criar
                                            <i class="material-icons right">cloud</i>
                                        </button>
                                        <div class="row"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>



                </form>
            </div>
        </div></div>
    <div class="col s12 m4 l2"></div>
</div>


<%@ include file="footer.jsp" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="/js/materialize.min.js"></script>
<script>
    $(document).ready(function () {
        $('select').formSelect();
        $('.sidenav').sidenav();
    });
</script>
<script src="/js/selecionaAluno.js"></script>
</body>
</html>