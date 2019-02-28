package com.ifpb.control.commands;

import com.ifpb.control.commands.Exceptions.CommandException;
import com.ifpb.model.dao.impl.TurmaVirtualDaoImpl;
import com.ifpb.model.dao.interfaces.TurmaVirtualDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mailson Dennis
 *
 */
public class TurmaVirtualController implements Command {

    private TurmaVirtualDao turmaVirtualDao;

    public TurmaVirtualController(){
        turmaVirtualDao = new TurmaVirtualDaoImpl();
    }


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String acao = request.getParameter("acao");
        switch(acao){
            case "criar":
                criarTurmaService(request,response);
                break;
            case "deletar":
                deletarTurmaService(request,response);
                break;
            case "listar":
                listarTurmaService(request,response);
                break;
            case "buscar":
                buscarTurmaService(request,response);
                break;
            case "atualizar":
                atualizarTurmaSerice(request,response);
                break;
            case "adicionarAluno":
                adicionarAlunoService(request,response);
                break;
            case "adicionarPodcast":
                adicioanarPodcastService(request,response);
                break;
        }
    }


    private void criarTurmaService(HttpServletRequest request, HttpServletResponse response) {
        //TODO
    }

    private void deletarTurmaService(HttpServletRequest request, HttpServletResponse response) {
        //TODO
    }

    private void listarTurmaService(HttpServletRequest request, HttpServletResponse response) {
        //TODO
    }

    private void buscarTurmaService(HttpServletRequest request, HttpServletResponse response) {
        //TODO
    }

    private void adicionarAlunoService(HttpServletRequest request, HttpServletResponse response) {
        //TODO
    }

    private void adicioanarPodcastService(HttpServletRequest request, HttpServletResponse response) {
        //TODO
    }

    private void atualizarTurmaSerice(HttpServletRequest request, HttpServletResponse response) {
        //TODO
    }


}
