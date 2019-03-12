package com.ifpb.control.commands;

import com.ifpb.control.commands.Exceptions.CommandException;
import com.ifpb.model.dao.Exceptions.DataAccessException;
import com.ifpb.model.dao.impl.UsuarioDaoImpl;
import com.ifpb.model.dao.interfaces.UsuarioDao;
import com.ifpb.model.domain.Usuario;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


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
                request.getRequestDispatcher("/Podcast/pages/timeline.html").forward(request,response);
            }else{
                throw new CommandException(402,"Falha de autenticação");
            }
        } catch (DataAccessException e) {
            throw new CommandException(403, "Falha ao acessar a base de dados");
        } catch (ServletException | IOException e) {
            throw new CommandException(404,"pagina principal não encontrada");
        }
    }

    private void salvarService(HttpServletRequest request, HttpServletResponse response){
        //TODO
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
