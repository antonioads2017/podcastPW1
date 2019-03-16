<div class="col s8">
    <c:forEach var="turma" items="${turmas}">
        <div class="card horizontal">

            <div class="card-stacked">

            <div class="card-content">
                <div class="col s9">
                    <h4 ${turma.nome}></h4>
                    <p ${turma.descricao}></p>
                </div>
                <div class="col s3">
                    <div class="right-align">
                        <a class="btn-floating waves-effect waves-light red" href="moduloPodcast.jsp"><i class="material-icons">close</i></a>
                    </div>
                </div>
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
    </c:forEach>
</div> <br>
<div class="col s4"><a class="btn-large waves-effect waves-light orange" href="criarturma.jsp">Criar turma virtual</a></div>

