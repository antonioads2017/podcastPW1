<%--
  Created by IntelliJ IDEA.
  User: mailson
  Date: 17/03/19
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<div id="modalUpload${turma.nome}" class="modal">
    <div class="modal-content">
        <center>
            <div class="row">
                <form class="s4" method="post" action="/inicio?comando=PodcastController&acao=salvarEmTurma" enctype="multipart/form-data">
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

                    <input type="hidden" name="nomeTurma" value="${turma.nome}"/>

                    <div>
                        <div class = "file-field input-field">
                            <div class = "btn">
                                <span>Browse</span>
                                <input type = "file" />
                            </div>

                            <div class = "file-path-wrapper">
                                <input class = "file-path validate" type = "text"
                                       placeholder = "Upload file" />
                            </div>
                        </div>
                    </div>
                    <div class="bottom">
                        <button class="btn"> Enviar PodCast </button>
                    </div>
                </form>
            </div>
        </center>
    </div>

</div>
