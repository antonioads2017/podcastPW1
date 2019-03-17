<%--
  Created by IntelliJ IDEA.
  User: camila
  Date: 14/03/19
  Time: 00:11
  To change this template use File | Settings | File Templates.
--%>

            <%--<li> <!-- Modal Trigger -->--%>
                <%--<a class="btn waves-effect waves-light orange btn modal-trigger" href="#modal2">Envie seu PodCast</a></li>--%>
    <%----%>



        <!-- Modal Structure -->
        <div id="modal2" class="modal">
            <div class="modal-content">
                <center>
                    <div class="row">
                        <form class="s4">
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



            <%--<li class="tab disabled"><a href="/inicio?comando=UsuariosController&acao=sair">Sair</a></li>--%>

    <nav>

        <div class="nav-wrapper">

            <a href="timeline.jsp" class="brand-logo white-text">IFCast</a>

            <ul class="hide-on-med-and-down  right">




                <li>

                    <div class="center row">

                        <div class="col s12" >

                            <div class="row">

                                <div class="input-field col s6 s12 black-text">

                                    <i class="white-text material-icons prefix">search</i>

                                    <input type="text" class="white-text" >

                                </div>

                            </div>

                        </div>

                    </div>

                </li>

                <li ><a href="perfilUsuario.jsp" class="white-text">${sessionScope.usuarioLogado.nome}</a></li>

                <li><a href="turmasvirtuais.jsp" class="white-text">Turmas virtuais</a></li>
<li> <a class="btn waves-effect waves-light orange btn modal-trigger" href="#modal2">Upload</a></li>
                <li><a href="/inicio?comando=UsuariosController&acao=sair">Sair</a></li>


            </ul>

        </div>

    </nav>



<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script>
    $(document).ready(function () {
        $('.modal').modal();
    });
</script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/js/materialize.min.js">
</script>
<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="../js/materialize.js"></script>
<script src="../js/init.js"></script>
