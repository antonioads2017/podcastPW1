<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
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
    <link href="../css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
</head>
<body>

<%@ include file = "headerLogged.jsp" %>
<div class="row"><div class="card horizontal">

    <div class="card-content">
        <img class="profile" src="http://www.wfmu.org/images/generic_avatar_300.png"/>
        <h4>Usuário </h4>
        <p>Aluno/Professor</p>
    </div>
    <div class="card-content">
        <div class="card-tabs">
            <ul class="tabs tabs-fixed-width">
                <li class="tab"><a href="#dados">Meus dados</a></li>
                <li class="tab"><a href="#settings">Configurações da conta</a></li>
            </ul>
        </div>
        <div class="card-content grey lighten-4">
            <div id="dados">
                <h4>Detalhes da conta:</h4>
                <p>Nome completo:</p>
                <p>Telefone: </p>
                <p>E-mail:</p>
                <p>Nascimento:</p>
            </div>
            <div id="settings"> <h4>Configuração e propriedades:</h4>
            <a href="editarUsuario.jsp">Editar dados</a><br>
            <a href="">Desativar conta</a></div>
        </div>

    </div>
</div></div>



<%@ include file = "footer.jsp" %>

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
