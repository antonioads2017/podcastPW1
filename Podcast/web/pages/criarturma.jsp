<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><title>IFCast - Criar turma </title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
        <title>IFCast</title>

        <!-- CSS  -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="../css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link href="../css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/></head>
    <body>
    <%@ include file = "headerLogged.jsp" %>

    <div class="card-panel">
        <div class="row">
            <form class="col s12">
                <div class="row">
                    <span class="card-title">Nova turma virtual</span>
                    <div class="input-field col s12">
                        <input id="nome" type="text" class="validate">
                        <label for="nome">Nome</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s12">
                        <input id="descricao" type="text" class="validate">
                        <label for="descricao">Descrição</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s12">
                        <div id="membros">
                            <a class="btn-floating btn-large waves-effect waves-light red"><i class="material-icons">add</i></a>  Adicionar membros

                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s12">
                        <button class="btn waves-effect waves-light" type="submit" name="action">Criar
                            <i class="material-icons right">cloud</i>
                        </button>
                    </div>
                </div>

            </form>
        </div></div>

    <%@ include file = "footer.jsp" %>
    </body>
</html>