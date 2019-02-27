package com.ifpb.control.commands;

import com.ifpb.control.commands.Exceptions.CommandException;
import com.ifpb.model.dao.impl.PodcastDaoImpl;
import com.ifpb.model.dao.interfaces.PodcastDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mailson Dennis
 *
 */
public class PodcastController implements Command {

    private PodcastDao podcastDao;

    public PodcastController(){
        podcastDao = new PodcastDaoImpl();
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String acao = request.getParameter("acao");
        switch (acao){
            case "criar":
                criarTurmaService(request,response);
                break;
            case "deletar":
                deletarTurmaService(request,response);
                break;
            case "listar":
                listarTurmasService(request,response);
                break;
            case "buscar":
                buscarTurmaService(request,response);
                break;
            case "atualizar":
                atualziarTurmaService(request,response);
                break;
        }
    }


    private void criarTurmaService(HttpServletRequest request, HttpServletResponse response) {
        //TODO
    }

    private void deletarTurmaService(HttpServletRequest request, HttpServletResponse response) {
        //TODO
    }

    private void listarTurmasService(HttpServletRequest request, HttpServletResponse response) {
        //TODO
    }

    private void buscarTurmaService(HttpServletRequest request, HttpServletResponse response) {
        //TODO
    }

    private void atualziarTurmaService(HttpServletRequest request, HttpServletResponse response) {
        //TODO
    }

}
