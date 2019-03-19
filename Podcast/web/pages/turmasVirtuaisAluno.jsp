<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div class="col s8">
    <c:forEach var="turma" items="${turmas}">

        <%@ include file = "moduloUpload.jsp" %>

        <div class="card horizontal">

            <div class="card-stacked">
                <div class="card-content">
                    <h4>
                        <a href="/inicio?comando=TurmaVirtualController&acao=buscar&nomeTurma=${''.concat(turma.nome).replace(' ','_')}">${turma.nome}</a></h4>
                    <p>${turma.descricao}</p>
                </div>
                <div class="card-action">
                    <div class="card-tabs">
                        <ul class="tabs tabs-fixed-width">
                            <li class="tab"><a href="#podcasts">Podcasts</a></li>
                        </ul>
                    </div>
                    <div class="card-content grey lighten-4">

                        <div id="podcasts">
                            <a class="btn-large waves-effect waves-light orange modal-trigger" href="#modalUpload${''.concat(turma.nome).replace(' ','_')}">Upload de novo podcast</a>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </c:forEach>
</div>


