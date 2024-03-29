<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt">
<head>
    <meta http-equiv="Content-Type" charset="UTF-8" content="text/html">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0">
    <title>IFCast</title>

    <style>
        <jsp:include page="css/materialize.css" />
        <jsp:include page="css/style.css" />
        <jsp:include page="css/home.css" />
    </style>

</head>
<body>
<img src="img/invisibleBG.png" class="fundo">
<%--&lt;%&ndash;<jsp: include page=“/pages/header.jsp”/>&ndash;%&gt;--%>
<%--<%@ include file = "/pages/header.jsp" %>--%>
<div class="section no-pad-bot" id="index-banner">
    <div class="container">
        <br><br>
        <h1 class="header center white-text">Conecte-se ao IFCast</h1>
        <div class="row center">
            <h5 class="header col s12 light white-text">Descubra, faça e compartilhe podcasts.</h5>
        </div>
        <div class="row center">

            <!-- Modal Trigger -->
            <a class="btn-large waves-effect waves-light orange accent-4 btn modal-trigger" href="#modal2">Cadastre-se
                gratuitamente</a> <p class="white-text">ou</p>  <a class="waves-effect waves-light btn modal-trigger transparent" href="#modal1">Entrar</a>

            <!-- Modal Structure -->
            <div id="modal1" class="modal">
                <div class="modal-content">
                    <center>
                        <div class="row">
                            <form class="col10 s10"
                                  action="/inicio?comando=UsuariosController&acao=autenticar" method="POST">
                                <div class="row">
                                    <div class="input-field col10 s10">
                                        <input id="email" type="email" name="email" class="validate">
                                        <label for="email">E-mail</label>
                                    </div>
                                    <div class="input-field col10 s10">
                                        <input id="password" type="password" name="senha" class="validate">
                                        <label for="password">Senha</label>
                                    </div>
                                    <button class="btn waves-effect waves-light" type="submit" name="action">Log-In

                                    </button>
                                </div>
                            </form>
                        </div>
                    </center>
                </div>

            </div>

            <!-- Modal Structure -->
            <div id="modal2" class="modal">
                <div class="modal-content">
                    <center>
                        <div class="row">
                            <form class="col10 s10" action="/inicio?comando=UsuariosController&acao=salvar"
                                  method="POST">
                                <div class="row">
                                    <c:if test="${msgErro!=null}">
                                        <span id="Erro">${msgErro}</span>
                                    </c:if>
                                   <div class="input-field col10 s10">
                                        <input id="name" type="text" class="validate" name="nome" value="${usuario!=null ? usuario.nome : ""}" maxlength="40" required>
                                       <label for="name">Nome<font color="red"> * </font></label></div>
                                    <div class="input-field col10 s10">
                                        <input id="email" type="email" class="validate" name="email" value="${usuario!=null ? usuario.email : ""}" required>
                                        <label for="email">E-mail<font color="red"> * </font></label></div>
                                    <div class="input-field col10 s10">
                                        <input id="password" type="password" class="validate" name="senha" value="${usuario!=null ? usuario.senha: ""}" minlength="6" required>
                                        <label for="password">Senha<font color="red"> * </font></label></div>
                                    <div class="input-field col10 s10">
                                        <input id="cellphone" type="text" class="validate" name="telefone" value="${usuario!=null && usuario.telefone != null ? usuario.telefone : ""}">
                                        <label for="cellphone">Telefone</label>
                                    </div>
                                    <div class="input-field col10 s10">
                                        <input id="date" type="date" class="validate" name="nascimento" value="${usuario!=null ? usuario.nascimento : ""}" required>
                                        <label for="date">Data de Nascimento<font color="red"> * </font></label>
                                    </div>

                                    <div class="input-field col10 s10">Função

                                        <p>
                                            <label>
                                                <input name="FUNCTION" type="radio" value="professor" />
                                                <span>Professor</span>
                                            </label>

                                            <label>
                                                <input name="FUNCTION" type="radio" value="aluno" checked/>
                                                <span>Aluno</span>
                                            </label>
                                        </p>


                                    </div>

                                    <div class="input-field col10 s10">Sexo

                                        <p>
                                            <label>
                                                <input name="GENDER" type="radio" value="female"/>
                                                <span>F</span>
                                            </label>

                                            <label>
                                                <input name="GENDER" type="radio" value="male" checked/>
                                                <span>M</span>
                                            </label>
                                        </p>


                                    </div>

                                    <button class="btn waves-effect waves-light" type="submit" name="action">Cadastrar

                                    </button>
                                </div>
                            </form>
                        </div>
                    </center>
                </div>

            </div>
        </div>
        <br><br>

    </div>
</div>



<!--  Scripts-->
<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery.maskedinput/1.4.1/jquery.maskedinput.min.js"></script>
<script>
    $(document).ready(function () {
        $('.modal').modal();
    });
</script>
<script src="js/materialize.js"></script>
<script src="js/init.js"></script>

<script src="js/mask.js"></script>
<c:if test="${cadastroSucesso != null}">
    <script>
        $(document).ready(function(){

            M.toast({html: 'Usuário cadastrado com sucesso!'}, 4000)

        });
    </script>
</c:if>
</body>
</html>
