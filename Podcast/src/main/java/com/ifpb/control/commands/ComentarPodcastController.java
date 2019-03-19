package com.ifpb.control.commands;

import com.ifpb.control.commands.Exceptions.CommandException;
import com.ifpb.model.dao.Exceptions.DataAccessException;
import com.ifpb.model.dao.impl.ComentarioDaoImpl;
import com.ifpb.model.dao.impl.PodcastDaoImpl;
import com.ifpb.model.dao.impl.UsuarioDaoImpl;
import com.ifpb.model.dao.interfaces.ComentarioDao;
import com.ifpb.model.dao.interfaces.PodcastDao;
import com.ifpb.model.dao.interfaces.UsuarioDao;
import com.ifpb.model.domain.Comentario;
import com.ifpb.model.domain.Usuario;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author Mailson Dennis
 *
 */
public class ComentarPodcastController implements Command {

    private ComentarioDao comentarioDao;
    private PodcastDao podcastDao;

    public ComentarPodcastController(){
        comentarioDao = new ComentarioDaoImpl();
        podcastDao = new PodcastDaoImpl();
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

        }
    }

    private void criarComentarioService(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String comentario = request.getParameter("comentario");
        String referenciaPodcast = request.getParameter("podcastPath");

        Comentario coment = new Comentario();
        coment.setTexto(comentario);
        coment.setUsuario((Usuario) request.getSession().getAttribute("usuarioLogado"));
        try {
           comentarioDao.salvar(coment,referenciaPodcast);
        } catch (DataAccessException e) {
            throw new CommandException(400,"Falha ao salvar o comentário na base de dados!");
        }

        try {
            response.sendRedirect("/inicio?comando=PodcastController&acao=buscar&referencia="+referenciaPodcast);
        } catch (IOException e) {
            throw new CommandException(404,"Falha ao recarregar a página!");
        }
    }

    private void apagarComentarioService(HttpServletRequest request, HttpServletResponse response) {
        //TODO
    }

    private void editarComentarioService(HttpServletRequest request, HttpServletResponse response) {
        //TODO
    }




}
