<%--
  Created by IntelliJ IDEA.
  User: camila
  Date: 14/03/19
  Time: 00:05
  To change this template use File | Settings | File Templates.
--%>
<nav class="transparent" role="navigation">
    <div class="nav-wrapper container"><a id="logo-container" href="#" class="brand-logo">IFCast</a>
        <ul class="right hide-on-med-and-down">
            <li><!-- Modal Trigger -->
                <a class="waves-effect waves-light btn modal-trigger" href="#modal1">Entrar</a>

                <!-- Modal Structure -->
                <div id="modal1" class="modal">
                    <div class="modal-content">
                        <center>
                            <div class="row">
                                <form class="col10 s10"
                                      action="/inicio?comando=UsuariosController&acao=autenticar" method="POST">
                                    <div class="row">
                                        <div class="input-field col10 s10">
                                            <input id="email" type="email" name="email" class="validate">
                                            <label for="email">E-mail</label>
                                        </div>
                                        <div class="input-field col10 s10">
                                            <input id="password" type="password" name="senha" class="validate">
                                            <label for="password">Senha</label>
                                        </div>
                                        <button class="btn waves-effect waves-light" type="submit" name="action">Log-In
                                            <i class="material-icons right">cloud</i>
                                        </button>
                                    </div>
                                </form>
                            </div>
                        </center>
                    </div>

                </div>
            </li>
            <li>
                <a href="#">+</a>
            </li>
        </ul>

        <ul id="nav-mobile" class="sidenav">
            <li><a href="#">Navbar Link</a></li>
        </ul>
        <a href="#" data-target="nav-mobile" class="sidenav-trigger"><i class="material-icons">menu</i></a>
    </div>
</nav>
