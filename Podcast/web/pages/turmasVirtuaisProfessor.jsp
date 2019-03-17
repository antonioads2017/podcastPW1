<div class="col s8">
    <c:forEach var="turma" items="${turmas}">


        <div class="card horizontal">

            <div class="card-stacked">

                <div class="card-content">
                    <div class="col s9">
                        <h4>
                            <a href="/inicio?comando=TurmaVirtualController&acao=buscar&nomeTurma=${turma.nome}">${turma.nome}</a>
                        </h4>
                        <p>${turma.descricao}</p>
                    </div>
                    <div class="col s3">
                        <div class="right-align">
                            <a class="btn-floating waves-effect waves-light red"
                               onclick="showModal(this,'md1${turma.nome}')"><i class="material-icons">close</i></a>
                        </div>
                    </div>
                    <div id="md1${turma.nome}" class="modal">
                        <div class="modal-content">
                            <h4>Porfavor confirme</h4>
                            <p>Deseja continuar com esta ação?</p>
                        </div>
                        <div class="modal-footer">
                            <a href="" class="waves-effect waves-red btn-flat"
                               onclick="$('#md1${turma.nome}').closeModal(); return false;">Cancelar</a>
                            <a href="/inicio?comando=TurmaVirtualController&acao=deletar&nomeTurma=${turma.nome}"
                               class="waves-effect waves-green btn-flat" id="md1_YesBtn">Sim</a>
                        </div>
                    </div>
                    <div id="md2${turma.nome}" class="modal">
                        <form>
                            <div class="modal-content">
                                <div class="row">
                                    <div class="col s12">
                                        <h4 class="center-align">Selecione os alunos que deseja adicionar a turma</h4>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col s6">
                                        <div class="input-field col s8">
                                            <select class="icons" id="select">
                                                <option value="" disabled selected>Selecione um aluno</option>
                                                <c:forEach var="aluno" items="${alunos}">
                                                    <option value="${aluno.email}" data-icon="#">${aluno.email}</option>
                                                </c:forEach>
                                            </select>
                                            <label>Materialize Select</label>
                                        </div>
                                        <div class="input-field col s4">
                                            <div id="membros">
                                                <a class="btn-floating btn-large waves-effect waves-light red"><i
                                                        class="material-icons" onclick="adicionaAluno()">add</i></a> Adicionar membros
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col s6">
                                        <div class="col s12">
                                            <div class="card blue-grey darken-1">
                                                <div class="card-content white-text">
                                                    <span class="card-title">Alunos adicionados</span>
                                                    <ul class="collection with-header" id="listaAlunos" >
                                                        <c:forEach var="alunoAdicionado" items="${turma.participantes}">
                                                            <li class="collection-item black-text" id="${alunoAdicionado.email}Li">${alunoAdicionado.email}
                                                                <a onclick="removerAluno('${alunoAdicionado.email}')" class="secondary-content"><i class="material-icons">close</i>
                                                                </a>
                                                            </li>
                                                            <input type="hidden" id="${alunoAdicionado.email}" value="${alunoAdicionado.email}" name="alunos">
                                                        </c:forEach>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <a href="" class="waves-effect waves-red btn-flat"
                                   onclick="$('#md2${turma.nome}').closeModal(); return false;">Cancelar</a>
                                <input type="submit" class="waves-effect waves-green btn-flat" id="md2_YesBtn" value="atualizar turma"/>
                            </div>
                        </form>
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
                            <a onclick="showModal(this,'md2${turma.nome}')" class="btn-large waves-effect waves-light orange" >Adicionar membros</a>

                        </div>
                        <div id="podcasts${turma.nome}">
                            <a class="btn-large waves-effect waves-light orange" href="">Upload de novo podcast</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </c:forEach>
    <br>
    <div class="col s4"><a class="btn-large waves-effect waves-light orange" href="criarturma.jsp">Criar turma
        virtual</a></div>
</div>
<script>
    function showModal(but, modal) {
        $('#' + modal).openModal();
        $('#' + modal + '_YesBtn').click(function () {
            $('#' + modal).closeModal();
            document.location = but.href;
        });
    }
</script>
<script src="/js/selecionaAluno.js"></script>