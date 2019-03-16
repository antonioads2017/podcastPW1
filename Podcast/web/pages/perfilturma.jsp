<%--
  Created by IntelliJ IDEA.
  User: mailson
  Date: 16/03/19
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head lang="pt">
    <meta http-equiv="Content-Type" charset="UTF-8" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
    <title>IFCast - ${turma.nome}</title>

    <!-- CSS  -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="../css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
    <link href="../css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
</head>
    <body>
        <%@ include file = "headerLogged.jsp" %>


        <div class="row">
            <div class="col s9">
                <div class="card horizontal left-align">
                    <div class="card-title">
                        <h4>${turma.nome}Nome da turma</h4>
                    </div>
                    <div class="card-stacked">
                        <div class="card-content">
                            ajsduihausedhaisdjiasjdiasjdiasjdiasjdiajsdiasjdiajsdiajsdijasdijasidjaidsjaisd
                        </div>
                        <div class="card-action">
                            <c:if test="${sessionScope.usuarioLogado.tipo == 'ALUNO'}">
                                <a class="waves-effect waves-light btn-large"><i class="material-icons right">close</i>Sair da turma</a>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col s3">
                <span class="center-align">Criado por: Mailson ${turma.criador.nome}</span>
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
