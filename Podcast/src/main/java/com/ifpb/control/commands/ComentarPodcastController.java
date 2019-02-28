package com.ifpb.control.commands;

import com.ifpb.control.commands.Command;
import com.ifpb.control.commands.Exceptions.CommandException;
import com.ifpb.model.dao.impl.ComentarioDaoImpl;
import com.ifpb.model.dao.interfaces.ComentarioDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ComentarPodcastController implements Command {

    private ComentarioDao comentarioDao;

    public ComentarPodcastController(){
        comentarioDao = new ComentarioDaoImpl();
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String acao = request.getParameter("acao");
        switch(acao){
            case "comentar":
                criarComentarioService(request,response);
                break;
            case "apagarComentario":
                apagarComentarioService(request,response);
                break;
            case "editarComentario":
                editarComentarioService(request,response);
                break;
            case "listarComentarios":
                listarComentarioService(request,response);
                break;
            case "buscarComentario":
                buscarComentarioService(request,response);
                break;
        }
    }

    private void criarComentarioService(HttpServletRequest request, HttpServletResponse response) {
        //TODO
    }

    private void apagarComentarioService(HttpServletRequest request, HttpServletResponse response) {
        //TODO
    }

    private void editarComentarioService(HttpServletRequest request, HttpServletResponse response) {
        //TODO
    }

    private void listarComentarioService(HttpServletRequest request, HttpServletResponse response) {
        //TODO
    }

    private void buscarComentarioService(HttpServletRequest request, HttpServletResponse response) {
        //TODO
    }

}
