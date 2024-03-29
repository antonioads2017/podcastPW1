package com.ifpb.control.commands;

import com.ifpb.control.commands.Exceptions.CommandException;
import com.ifpb.model.dao.Exceptions.DataAccessException;
import com.ifpb.model.dao.impl.UsuarioDaoImpl;
import com.ifpb.model.dao.interfaces.UsuarioDao;
import com.ifpb.model.domain.Enum.NivelAcesso;
import com.ifpb.model.domain.Enum.Sexo;
import com.ifpb.model.domain.Enum.Tipo;
import com.ifpb.model.domain.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static jdk.nashorn.internal.objects.NativeError.getFileName;


/**
 *
 * @author Mailson Dennis
 *
 */
@MultipartConfig()
public class UsuariosController implements Command {

    private UsuarioDao usuarioDao;

    private Logger log=Logger.getLogger("log");

    public UsuariosController(){
        usuarioDao = new UsuarioDaoImpl();
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String acao = request.getParameter("acao");
        log.info(acao);
        switch(acao){
            case "autenticar":
                autenticarService(request,response);
                break;
            case "salvar":
                salvarService(request,response);
                break;
            case "deletar":
                deletarService(request,response);
                break;
            case "listar":
                listarService(request,response);
                break;
            case "salvarImagem":
                salvarImagemService(request,response);
                break;
            case "buscar":
                buscarService(request,response);
                break;
            case "desativarConta":
                desativarContaService(request,response);
                break;
            case "atualizar":
                atualizarService(request,response);
                break;
            case "listarAlunos":
                listarAlunosService(request,response);
                break;
            case "listarProfessores":
                listarProfessoresService(request,response);
                break;
            case "buscarAlunosTurma":
                buscarAlunosTurma(request,response);
                break;
            case "tornarAdmin":
                tornarAdmin(request,response);
                break;
            case "sair":
                logoutService(request,response);
                break;
        }
    }


    private void tornarAdmin(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String referece = request.getParameter("emailUsuario");
        try {
            usuarioDao.setAdmin(referece);
        } catch (DataAccessException e) {
            throw new CommandException(400,"Falha a atualizar Nivel do Usuário");
        }
        try {
            response.sendRedirect("/pages/admin/gerencia.jsp");
        } catch (IOException e) {
            log.severe("Falha ao carregar a página de gerência de usuários");
            throw new CommandException(404,"Falha ao carregar a página de gerência de usuários");
        }
    }

    private void autenticarService(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        try {
            if(usuarioDao.autenticarUsuario(email,senha)){
                Usuario user = usuarioDao.buscar(email);
                request.getSession().setAttribute("usuarioLogado",user);
                response.sendRedirect("/pages/timeline.jsp");
                log.info("Logado");
            }else{
                log.severe("Falha na autencação");
                response.sendRedirect("index.jsp");
            }
        } catch (DataAccessException| IOException e) {
            log.severe("Falha ao acessar a base de dados");
            throw new CommandException(403, "Falha ao acessar a base de dados");
        }
    }

    private void logoutService(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        request.getSession().invalidate();
        try {
            response.sendRedirect("index.jsp");
            log.info("Logout");
        } catch (IOException e) {
            log.severe("Não foi possivel realizar logout");
            throw new CommandException(400,"Não foi possivel realizar logout");
        }

    }

    private void salvarService(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String nascimento = request.getParameter("nascimento");
        String telefone = request.getParameter("telefone");
        String sexo = request.getParameter("GENDER");
        String funcao = request.getParameter("FUNCTION");

        //=============================================================

        Usuario user = new Usuario();
        user.setNome(nome);
        user.setEmail(email);
        user.setSenha(senha);
        user.setTelefone(telefone);
        if(sexo.equals("female")){
            user.setSexo(Sexo.FEMININO);
        }else{
            user.setSexo(Sexo.MASCULINO);
        }
        if(funcao.equals("aluno")){
            user.setTipo(Tipo.ALUNO);
        }else{
            user.setTipo(Tipo.PROFESSOR);
        }
        user.setNivelAcesso(NivelAcesso.USER);
        user.setNascimento(LocalDate.parse(nascimento));

        //==============================================================

        String msgErro= "";

        try {
            if(usuarioDao.buscar(user.getEmail()) == null){
                usuarioDao.salvar(user);
                request.setAttribute("cadastroSucesso","Usuário cadastrado com sucesso");
                request.getRequestDispatcher("/index.jsp").forward(request,response);
                log.info("Cadastro com sucesso o usuario "+user.getNome());
            }else{
                msgErro = "Já existe um usuário cadastrado com esse email";
                request.setAttribute("usuario",user);
                request.setAttribute("Erro",msgErro);
                request.getRequestDispatcher("index.jsp").forward(request,response);
                log.severe(msgErro);
                //throw new CommandException(403,"Já existe um usuário cadastrado com esse email");
            }
        } catch (DataAccessException e) {
            log.severe("Falha ao salvar um usuario");
            throw new CommandException(400,"Falha ao salvar um usuário!");
        } catch (ServletException | IOException e) {
            log.severe("Erro interno");
            throw new CommandException(405,"Erro interno!");
        }
    }

    private void deletarService(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String reference = request.getParameter("emailUsuario");
        try {
            usuarioDao.remover(reference);
            log.info("Usuario removido com sucesso");
        } catch (DataAccessException e) {
            log.severe("Não foi possivel excluir o usuário");
            throw new CommandException(400,"Não foi possível excluir o usuário");
        }

        try {
            response.sendRedirect("/pages/admin/gerencia.jsp");
        } catch (IOException e) {
            log.severe("Falha ao carregar a página de gerência de usuários");
            throw new CommandException(404,"Falha ao carregar a página de gerência de usuários");
        }
    }

    private void listarService(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        List<Usuario> usuarios;
        try{
            usuarios= usuarioDao.listar();
            log.info("Usuarios listados");
        } catch (DataAccessException e) {
            log.severe("Não foi possivel listar os usuários");
            throw new CommandException(402,"Não foi possível listar os usuários");
        }
        request.setAttribute("usuarios",usuarios);
    }

    private void buscarService(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String reference = request.getParameter("emailUsuario");
        Usuario usuario;
        try{
            usuario = usuarioDao.buscar(reference);
            log.info("Usuário buscado");
        } catch (DataAccessException e) {
            log.severe("Falha na busca do usuário");
            throw new CommandException(402,"Falha ao buscar o usuário");
        }
        request.setAttribute("usuario",usuario);
    }

    private void atualizarService(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String email = request.getParameter("email");
        String nome = request.getParameter("nome");
        String senha = request.getParameter("senha");
        String telefone = request.getParameter("telefone");
        String nascimento = request.getParameter("nascimento");

        //=============================================================

        Usuario usuarioLogado = (Usuario) request.getSession().getAttribute("usuarioLogado");
        String emailUsuarioLogado = usuarioLogado.getEmail();
        boolean atualizado = false;
        if(!email.equals(emailUsuarioLogado)){
            usuarioLogado.setEmail(email);
            atualizado = true;
        }
        if(!nome.equals(usuarioLogado.getNome())){
            usuarioLogado.setNome(nome);
            atualizado = true;
        }
        if(!senha.equals(usuarioLogado.getSenha())){
            usuarioLogado.setSenha(senha);
            atualizado = true;
        }
        if(!telefone.equals(usuarioLogado.getTelefone())){
            usuarioLogado.setTelefone(telefone);
            atualizado = true;
        }
        if(!usuarioLogado.getNascimento().equals(LocalDate.parse(nascimento))){
            usuarioLogado.setNascimento(LocalDate.parse(nascimento));
            atualizado = true;
        }

        //===============================================================

        try {
            usuarioDao.atualizar(emailUsuarioLogado,usuarioLogado);

        } catch (DataAccessException e) {
            throw new CommandException(400,"Falah ao atualizar os dados do usuário no banco");
        }

        if(!atualizado){
            request.setAttribute("dadosAtualizados","Nenhum dado foi alterado!");
        }else{
            request.setAttribute("dadosAtualizados","Dados atualziados com sucesso!");
        }


        request.getSession().setAttribute("usuarioLogado",usuarioLogado);
        try {
            request.getRequestDispatcher("/pages/perfilUsuario.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            throw new CommandException(404,"Falha ao carregar a página de perfil");
        }


    }

    private void listarAlunosService(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        List<Usuario> alunos;
        try {
            alunos = usuarioDao.listarAlunos();
            log.info("Alunos listados");
        } catch (DataAccessException e) {
            log.severe("Não foi possivel listar os alunos");
            throw new CommandException(402,"Não foi possível listar os alunos");
        }
        request.setAttribute("alunos",alunos);
    }

    private void listarProfessoresService(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        List<Usuario> professores;
        try {
            professores = usuarioDao.listarAlunos();
            log.info("Professores listados");
        } catch (DataAccessException e) {
            log.severe("Não foi possivel listar os professores");
            throw new CommandException(402,"Não foi possível listar os professores");
        }
        request.setAttribute("professores",professores);
    }

    private void buscarAlunosTurma(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String nomeTurma = request.getParameter("nomeTurma");
        List<Usuario> alunos;
        try{
            alunos = usuarioDao.buscarAlunosPorTurma(nomeTurma);
            log.info("Alunos listados na turma");
        } catch (DataAccessException e) {
            log.severe("Não foi possivel listar os alunos da turma desejada");
            throw new CommandException(402,"Não foi possível listar os alunos da turma desejada");
        }
        request.setAttribute("alunos",alunos);
    }

    private void salvarImagemService(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        try {
            String id = new Double(Math.random()).toString();
            Part part = request.getPart("foto");
            String fileName = id+getFileName(part);
            String uploadImgPath = request.getServletContext().getAttribute("IMG_DIR").toString();
            part.write(uploadImgPath + File.separator + fileName);
            Usuario usuarioLogado = ((Usuario)request.getSession().getAttribute("usuarioLogado"));
            usuarioDao.salvarFoto(fileName,usuarioLogado.getEmail());
            usuarioLogado.setFotoPath(fileName);
            request.getSession().setAttribute("usuarioLogado",usuarioLogado);
            request.getRequestDispatcher("/pages/perfilUsuario.jsp").forward(request,response);
        } catch (IOException |ServletException e) {
            throw new CommandException(400,"Falha ao salvar a foto no servidor");
        } catch (DataAccessException e) {
            throw new CommandException(400,"Falha ao acessar a base de dados");
        }
    }

    private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        System.out.println("content-disposition header= "+contentDisp);
        String[] tokens = contentDisp.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf("=") + 2, token.length()-1);
            }
        }
        return "";
    }

    private void desativarContaService(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String emailUsuario = request.getParameter("emailUsuario");
        try {
            usuarioDao.remover(emailUsuario);
        } catch (DataAccessException e) {
            throw new CommandException(400,"Falha ao excluir o usuário da base de dados");
        }

        request.getSession().invalidate();

        try {
            response.sendRedirect("index.jsp");
        } catch (IOException e) {
            throw new CommandException(404,"Falha ao carregar a página de login!");
        }
    }


}
