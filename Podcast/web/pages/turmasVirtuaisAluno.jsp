<div class="col s8">
    <c:forEach var="turma" items="${turmas}">

        <div class="card horizontal">

            <div class="card-stacked">
                <div class="card-content">
                    <h4>${turma.nome}</h4>
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
                            <a class="btn-large waves-effect waves-light orange" href="">Upload de novo podcast</a>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </c:forEach>
</div>


