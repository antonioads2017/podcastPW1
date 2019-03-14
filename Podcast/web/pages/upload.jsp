<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
    <title>IFCast - Upload</title>

    <!-- CSS  -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="../css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
    <link href="../css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
</head>
<body>
<%@ include file = "headerLogged.jsp" %>


<div class="row">
    <div class="center">
        <form class="center col s4">
            <div class="row">
                <div class="input-field col s6">
                    <input id="título" type="text" class="validate">
                    <label for="título">Título</label>
                </div>
                <div class="input-field col s6">
                    <input id="categoria" type="text" class="validate">
                    <label for="categoria">Categoria</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field col s12">
                    <input id="decricao" type="text" class="validate">
                    <label for="decricao">Descrição</label>
                </div>
            </div>
            <div class="file-field input-field">
                <div class="btn">
                    <span>Arquivo de áudio PodCast</span>
                    <input type="file">
                </div>
                <div class="file-path-wrapper">
                    <input class="file-path validate" type="text">
                </div>
            </div>
        </form>
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
