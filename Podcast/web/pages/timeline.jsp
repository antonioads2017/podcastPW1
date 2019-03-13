<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
    <title>IFCast - Início</title>

    <!-- CSS  -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="../css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
    <link href="../css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
</head>
<body>
<nav class="light-blue" role="navigation">
    <div class="nav-wrapper container"><a id="logo-container" href="#" class="brand-logo">IFCast</a>


        <ul class="right hide-on-med-and-down">
            <li>
                <form>
                    <div class="input-field">
                        <input id="search" type="search" required>
                        <label class="label-icon" for="search"><i class="material-icons">search</i></label>
                        <i class="material-icons">close</i>
                    </div>
                </form>
            </li>

            <li><a href="upload.jsp">Upload</a></li>
            <li>
                <ul id="dropdown" class="dropdown-content">
                    <li><a href="#">Meus dados</a>
                    </li>
                    <li><a href="turmasvirtuais.jsp">Turmas virtuais</a></li>
                    <li class="divider"></li>
                    <li><a href="#">Sair</a></li>
                </ul>

                <a class="dropdown-button" href="#" data-activates="dropdown">Usuário
                    <i class="mdi-navigation-arrow-drop-down right"></i></a>
            </li>
            <li><img class="profile"
                     src="https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_960_720.png"></li>

        </ul>

        <ul id="nav-mobile" class="sidenav">
            <li><a href="#">Navbar Link</a></li>
        </ul>
        <a href="#" data-target="nav-mobile" class="sidenav-trigger"><i class="material-icons">menu</i></a>
    </div>
</nav>
<div class="timeline">
    <div class="row">
        <div class="col s8 m3">
            <div class="card">
                <div class="card-image">
                    <img src="https://images-na.ssl-images-amazon.com/images/I/41AZ6IMW5gL.jpg" class="capa-podcast">
                    <span class="card-title">Bohemian Rhapsody</span>
                    <a class="btn-floating halfway-fab waves-effect waves-light red"><i class="material-icons">play_arrow</i></a>
                </div>
                <div class="card-content">
                    <p class="autor">Queen</p><br>
                    <p class="descricao"> Composta em 1975 por Freddie Mercury. Foi a primeira música a alcançar a
                        primeira posição duas vezes com a mesma versão.</p>
                </div>
            </div>
        </div>
    </div>


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
<script type="text/javascript"
        src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/js/materialize.min.js">
</script>
<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>

<script src="../js/materialize.js"></script>
<script src="../js/init.js"></script>

</body>
</html>
