<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
    <title>IFCast - Turmas virtuais</title>

    <!-- CSS  -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="../css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
    <link href="../css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
</head>
<body>
<%@ include file = "headerLogged.jsp" %>
<div class="row">
    <div class="col s12"><br>
        <h6>Suas turmas virtuais:</h6>
        <li class="divider"></li>
        <div class="col s8">
            <div class="card horizontal">

                <div class="card-stacked">
                    <div class="card-content">
                        <h4>Título</h4>
                        <p>Descrição</p>
                    </div>
                    <div class="card-action">
                        <div class="card-tabs">
                            <ul class="tabs tabs-fixed-width">
                                <li class="tab"><a href="#membros">Membros</a></li>
                                <li class="tab"><a href="#podcasts">Podcasts</a></li>
                            </ul>
                        </div>
                        <div class="card-content grey lighten-4">
                            <div id="membros">
                                <a class="btn-large waves-effect waves-light orange" href="">Adicionar membros</a>

                            </div>
                            <div id="podcasts">
                                <a class="btn-large waves-effect waves-light orange" href="">Upload de novo podcast</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <br>
        <div class="col s4"><a class="btn-large waves-effect waves-light orange" href="">Criar turma virtual</a></div>


    </div>
</div>



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
