package com.ifpb.control.commands;

import com.ifpb.control.commands.Exceptions.CommandException;
import com.ifpb.model.dao.impl.UsuarioDaoImpl;
import com.ifpb.model.dao.interfaces.UsuarioDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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

    private void autenticarService(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("ahusdhausd");
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
