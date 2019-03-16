<%--
  Created by IntelliJ IDEA.
  User: camila
  Date: 14/03/19
  Time: 00:11
  To change this template use File | Settings | File Templates.
--%>

<nav class="light-blue" role="navigation">
    <div class="nav-wrapper container"><a id="logo-container" href="#" class="brand-logo">IFCast</a>


        <ul class="right hide-on-med-and-down">
            <li>
                <form>
                    <div class="input-field">
                        <input id="search" type="search" required>
                        <label class="label-icon" for="search"><i class="material-icons">search</i></label>
                        <i class="material-icons">close</i>
                    </div>
                </form>
            </li>
            <li>

                <!-- Modal Trigger -->
                <a class="btn-large waves-effect waves-light orange btn modal-trigger" href="#modal2">Envie seu PodCast</a>

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

            </li>
            <li>
                <ul id="dropdown" class="dropdown-content">
                    <li><a href="/pages/perfilUsuario.jsp">Meus dados</a></li>
                    <li><a href="/pages/turmasvirtuais.jsp">Turmas virtuais</a></li>
                    <li><a href="/inicio?comando=UsuariosController&acao=sair">Sair</a></li>
                </ul>
                <a class="dropdown-button" href="#" data-activates="dropdown">Usuário
                    <i class="mdi-navigation-arrow-drop-down right"></i></a>
            </li>
            <li><img class="profile"
                     src="http://www.wfmu.org/images/generic_avatar_300.png"></li>
        </ul>
        <ul id="nav-mobile" class="sidenav">
            <li><a href="#">Navbar Link</a></li>
        </ul>
        <a href="#" data-target="nav-mobile" class="sidenav-trigger"><i class="material-icons">menu</i></a>
    </div>
</nav>

<script src="../js/dropdown.js"></script>
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
