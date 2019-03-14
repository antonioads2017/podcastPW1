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

            <li><a href="upload.jsp">Upload</a></li>
            <li>
                <ul id="dropdown" class="dropdown-content">
                    <li><a href="#">Meus dados</a>
                    </li>
                    <li><a href="turmasvirtuais.jsp">Turmas virtuais</a></li>
                    <li class="divider"></li>
                    <li><a href="#">Sair</a></li>
                </ul>

                <a class="dropdown-button" href="#" data-activates="dropdown">Usuário
                    <i class="mdi-navigation-arrow-drop-down right"></i></a>
            </li>
            <li><img class="profile"
                     src="https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_960_720.png"></li>

        </ul>

        <ul id="nav-mobile" class="sidenav">
            <li><a href="#">Navbar Link</a></li>
        </ul>
        <a href="#" data-target="nav-mobile" class="sidenav-trigger"><i class="material-icons">menu</i></a>
    </div>
</nav>