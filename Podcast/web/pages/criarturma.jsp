<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><title>IFCast - Criar turma </title></head>
    <body>
    <%@ include file = "headerLogged.jsp" %>

    <div class="row">
        <form class="col s12">
            <div class="row">

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
                        <a class="btn-large waves-effect waves-light orange" href="">Adicionar membros</a>

                    </div>
                </div>
            </div>
            <div class="row">
                <div class="input-field col s12">
                    <button class="btn waves-effect waves-light" type="submit" name="action">Criar Turma
                        <i class="material-icons right">cloud</i>
                    </button>
                </div>
            </div>

        </form>
    </div>

    <%@ include file = "footer.jsp" %>
    </body>
</html>