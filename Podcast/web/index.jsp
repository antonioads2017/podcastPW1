<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
    <title>IFCast</title>

    <!-- CSS  -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
    <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
</head>
<body>
<nav class="light-blue" role="navigation">
    <div class="nav-wrapper container"><a id="logo-container" href="#" class="brand-logo">IFCast</a>
        <ul class="right hide-on-med-and-down">
            <li><!-- Modal Trigger -->
                <a class="waves-effect waves-light btn modal-trigger" href="#modal1">Entrar</a>

                <!-- Modal Structure -->
                <div id="modal1" class="modal">
                    <div class="modal-content">
                        <center>
                            <div class="row">
                                <form class="col10 s10"
                                      action="/Podcast/inicio?comando=UsuariosController&acao=autenticar" method="POST">
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
                                            <i class="material-icons right">cloud</i>
                                        </button>
                                    </div>
                                </form>
                            </div>
                        </center>
                    </div>

                </div>
            </li>
            <li>
                <a href="#">+</a>
            </li>
        </ul>

        <ul id="nav-mobile" class="sidenav">
            <li><a href="#">Navbar Link</a></li>
        </ul>
        <a href="#" data-target="nav-mobile" class="sidenav-trigger"><i class="material-icons">menu</i></a>
    </div>
</nav>
<div class="section no-pad-bot" id="index-banner">
    <div class="container">
        <br><br>
        <h1 class="header center orange-text">Conecte-se ao IFCast</h1>
        <div class="row center">
            <h5 class="header col s12 light">Descubra, faça e compartilhe podcasts.</h5>
        </div>
        <div class="row center">

            <!-- Modal Trigger -->
            <a class="btn-large waves-effect waves-light orange btn modal-trigger" href="#modal2">Cadastre-se
                gratuitamente</a>

            <!-- Modal Structure -->
            <div id="modal2" class="modal">
                <div class="modal-content">
                    <center>
                        <div class="row">
                            <form class="col10 s10" action="/Podcast/inicio?comando=UsuariosController&acao=salvar"
                                  method="POST">
                                <div class="row">
                                   <div class="input-field col10 s10">
                                        <input id="name" type="text" class="validate" name="nome">
                                        <label for="name">Nome</label></div>
                                    <div class="input-field col10 s10">
                                        <input id="email" type="email" class="validate" name="email">
                                        <label for="email">E-mail</label></div>
                                    <div class="input-field col10 s10">
                                        <input id="password" type="password" class="validate" name="senha">
                                        <label for="password">Senha</label></div>
                                    <div class="input-field col10 s10">
                                        <input id="cellphone" type="text" class="validate" name="telefone">
                                        <label for="cellphone">Telefone</label>
                                    </div>
                                    <div class="input-field col10 s10">
                                        <input id="date" type="date" class="validate" name="nascimento">
                                        <label for="date">Data de Nascimento</label>
                                    </div>

                                    <div class="input-field col10 s10">Função

                                        <p>
                                            <label>
                                                <input name="FUNCTION" type="radio" value="professor"/>
                                                <span>Professor</span>
                                            </label>

                                            <label>
                                                <input name="FUNCTION" type="radio" value="aluno"/>
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
                                                <input name="GENDER" type="radio" value="male"/>
                                                <span>M</span>
                                            </label>
                                        </p>


                                    </div>

                                    <button class="btn waves-effect waves-light" type="submit" name="action">Cadastrar
                                        <i class="material-icons right">cloud</i>
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


<div class="container">
    <div class="section">

        <!--   Icon Section   -->
        <div class="row">
            <div class="col s12 m4">
                <div class="icon-block">
                    <h2 class="center light-blue-text"><i class="material-icons">mode_comment</i></h2>
                    <h5 class="center">Interaja com Usuários</h5>

                    <p class="light">Nossa plataforma permite a interação por comentários em podcasts.</p>
                </div>
            </div>

            <div class="col s12 m4">
                <div class="icon-block">
                    <h2 class="center light-blue-text"><i class="material-icons">keyboard_voice</i></h2>
                    <h5 class="center">Fácil acesso e upload</h5>

                    <p class="light">Nossa equipe preparou um ambiente prático e de fácil ultilização, para uma melhor
                        experiência do usuário.</p>
                </div>
            </div>

            <div class="col s12 m4">
                <div class="icon-block">
                    <h2 class="center light-blue-text"><i class="material-icons">group</i></h2>
                    <h5 class="center">Turmas virtuais</h5>

                    <p class="light">Com a criação de Turmas virtuais, nossa plataforma permite uma melhor interação de
                        usuários que participam de uma mesma turma.</p>
                </div>
            </div>
        </div>

    </div>
    <br><br>
</div>

<footer class="page-footer orange">
    <div class="container">
        <div class="row">
            <div class="col l6 s12">
                <h5 class="white-text">AMEC Solutions</h5>
                <p class="grey-text text-lighten-4">Projeto da disciplina de Programação Web 1 do professor Diego -
                    IFPB</p>


            </div>
            <div class="col l3 s12">
                <h5 class="white-text">Equipe</h5>
                <ul>
                    <li><a class="white-text" href="#!">Camila Carvalho</a></li>
                    <li><a class="white-text" href="#!">Mailson Dennis</a></li>
                    <li><a class="white-text" href="#!">Antonio Filho</a></li>
                    <li><a class="white-text" href="#!">Eduardo Lucas</a></li>
                </ul>
            </div>

        </div>
    </div>
    <div class="footer-copyright">
        <div class="container">
            Designed by AMEC Solutions using <a class="orange-text text-lighten-3" href="http://materializecss.com">Materialize</a>
        </div>
    </div>
</footer>


<!--  Scripts-->
<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script>
    $(document).ready(function () {
        $('.modal').modal();
    });
</script>
<script src="js/materialize.js"></script>
<script src="js/init.js"></script>

</body>
</html>
