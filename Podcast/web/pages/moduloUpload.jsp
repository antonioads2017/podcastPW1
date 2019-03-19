<%--
  Created by IntelliJ IDEA.
  User: mailson
  Date: 17/03/19
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div id="modalUpload${''.concat(turma.nome).replace(' ','_')}" class="modal">
    <div class="modal-content">
        <center>
            <div class="row">
                <form class="s4" method="post" action="/inicio?comando=PodcastController&acao=salvarEmTurma" enctype="multipart/form-data">
                    <div class="row">
                        <div class="input-field col s6">
                            <input id="título" type="text" class="validate" name="titulo" required>
                            <label for="título">Título</label>
                        </div>
                        <div class="input-field col s6">
                            <input id="categoria" type="text" class="validate" name="categoria" required>
                            <label for="categoria">Categoria</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12">
                            <input id="decricao" type="text" class="validate" name="descricao" required>
                            <label for="decricao">Descrição</label>
                        </div>
                    </div>

                    <input type="hidden" name="nomeTurma" value="${''.concat(turma.nome).replace(' ','_')}"/>

                    <div>
                        <div class = "file-field input-field">
                            <div class = "btn">
                                <span>Browse</span>
                                <input type = "file" name="audio" accept="audio/*" required/>
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
