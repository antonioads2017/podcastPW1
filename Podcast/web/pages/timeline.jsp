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

<%@ include file = "headerLogged.jsp" %>
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
