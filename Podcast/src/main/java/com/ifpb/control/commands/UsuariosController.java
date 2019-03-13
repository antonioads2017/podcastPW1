package com.ifpb.control.commands;

import com.ifpb.control.commands.Exceptions.CommandException;
import com.ifpb.control.services.Encode;
import com.ifpb.control.services.exceptions.EncodeExcpetion;
import com.ifpb.model.dao.Exceptions.DataAccessException;
import com.ifpb.model.dao.impl.UsuarioDaoImpl;
import com.ifpb.model.dao.interfaces.UsuarioDao;
import com.ifpb.model.domain.Enum.NivelAcesso;
import com.ifpb.model.domain.Enum.Sexo;
import com.ifpb.model.domain.Enum.Tipo;
import com.ifpb.model.domain.Usuario;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;


/**
 *
 * @author Mailson Dennis
 *
 */
public class UsuariosController implements Command {

    private UsuarioDao usuarioDao;

    public UsuariosController(){
        usuarioDao = new UsuarioDaoImpl();
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String acao = request.getParameter("acao");
        System.out.println(acao);
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
            case "buscar":
                buscarService(request,response);
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
        }
    }

    private void autenticarService(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        try {
            if(usuarioDao.autenticarUsuario(email,senha)){
                Usuario user = usuarioDao.buscar(email);
                request.getSession().setAttribute("usuariLogado",user);
                request.getRequestDispatcher("/Podcast/pages/timeline.jsp").forward(request,response);
            }else{
                throw new CommandException(402,"Falha de autenticação");
            }
        } catch (DataAccessException e) {
            throw new CommandException(403, "Falha ao acessar a base de dados");
        } catch (ServletException | IOException e) {
            throw new CommandException(404,"pagina principal não encontrada");
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

        try {
            if(usuarioDao.buscar(user.getEmail()) == null){
                usuarioDao.salvar(user);
                System.out.println("cadastrado com sucesso!");
            }else{
                throw new CommandException(403,"Já existe um usuário cadastrado com esse email");
            }
        } catch (DataAccessException e) {
            e.printStackTrace();
            throw new CommandException(400,"Falha ao salvar um usuário!");
        }
    }

    private void deletarService(HttpServletRequest request, HttpServletResponse response) {
        //TODO
    }

    private void listarService(HttpServletRequest request, HttpServletResponse response) {
        //TODO
    }

    private void buscarService(HttpServletRequest request, HttpServletResponse response) {
        //TODO
    }

    private void atualizarService(HttpServletRequest request, HttpServletResponse response) {
        //TODO
    }

    private void listarAlunosService(HttpServletRequest request, HttpServletResponse response) {
        //TODO
    }

    private void listarProfessoresService(HttpServletRequest request, HttpServletResponse response) {
        //TODO
    }

    private void buscarAlunosTurma(HttpServletRequest request, HttpServletResponse response) {
        //TODO
    }



}
