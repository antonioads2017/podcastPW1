<div class="col s8">
    <c:forEach var="turma" items="${turmas}">
        <div class="card horizontal">

            <div class="card-stacked">

            <div class="card-content">
                <div class="col s9">
                    <h4><a href="/inicio?comando=TurmaVirtualController&acao=buscar&nomeTurma=${turma.nome}">${turma.nome}</a></h4>
                    <p>${turma.descricao}</p>
                </div>
                <div class="col s3">
                    <div class="right-align">
                        <a class="btn-floating waves-effect waves-light red" onclick="showModal(this,'md1${turma.nome}')"><i class="material-icons">close</i></a>
                    </div>
                </div>
                <div id="md1${turma.nome}" class="modal">
                    <div class="modal-content">
                        <h4>Porfavor confirme</h4>
                        <p>Deseja continuar com esta ação?</p>
                    </div>
                    <div class="modal-footer">
                        <a href="" class="waves-effect waves-red btn-flat" onclick="$('#md1${turma.nome}').closeModal(); return false;">Cancelar</a>
                        <a href="/inicio?comando=TurmaVirtualController&acao=deletar&nomeTurma=${turma.nome}" class="waves-effect waves-green btn-flat" id="md1_YesBtn">Sim</a>
                    </div>
                </div>
            </div>
        <div class="card-action">
            <div class="card-tabs">
                <ul class="tabs tabs-fixed-width">
                    <li class="tab"><a href="#membros${turma.nome}">Membros</a></li>
                    <li class="tab"><a href="#podcasts${turma.nome}">Podcasts</a></li>
                </ul>
            </div>
            <div class="card-content grey lighten-4">
                <div id="membros${turma.nome}">
                    <a class="btn-large waves-effect waves-light orange" href="">Adicionar membros</a>

                </div>
                <div id="podcasts${turma.nome}">
                    <a class="btn-large waves-effect waves-light orange" href="">Upload de novo podcast</a>
                </div>
            </div>
        </div>
    </div>
</div>
    </c:forEach>
</div> <br>
<div class="col s4"><a class="btn-large waves-effect waves-light orange" href="criarturma.jsp">Criar turma virtual</a></div>

<script>
    function showModal(but, modal){
        $('#' + modal).openModal();
        $('#' + modal + '_YesBtn').click(function(){ $('#' + modal).closeModal(); document.location = but.href; });
    }
</script>