package com.ifpb.control.commands;

import com.ifpb.control.commands.Exceptions.CommandException;
import com.ifpb.model.dao.Exceptions.DataAccessException;
import com.ifpb.model.dao.impl.PodcastDaoImpl;
import com.ifpb.model.dao.interfaces.PodcastDao;
import com.ifpb.model.domain.Podcast;
import com.ifpb.model.domain.Usuario;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

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
            case "salvar":
                salvarPodcastService(request,response);
                break;
            case "deletar":
                deletarPodcastService(request,response);
                break;
            case "listar":
                listarPodcastService(request,response);
                break;
            case "buscar":
                buscarPodcastService(request,response);
                break;
            case "atualizar":
                atualziarPodcastService(request,response);
                break;
            case "salvarEmTurma":
                salvarEmTurmaService(request,response);
                break;
        }
    }

    private void salvarPodcastService(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        try{
            Podcast podcast = salvarAudio(request,response);
            podcastDao.salvar(podcast);
        } catch (ServletException | IOException e) {
            throw new CommandException(400,"Não foi possível realizar o upload do podcast");
        } catch (DataAccessException e) {
            throw new CommandException(400,"Não foi possível salvar o podcast na base de dados!");
        }

        try {
            response.sendRedirect("/pages/timeline.jsp");
        } catch (IOException e) {
            throw new CommandException(404,"Não foi possível carregar a página de timeline");
        }
    }

    private void deletarPodcastService(HttpServletRequest request, HttpServletResponse response) {

    }

    private void listarPodcastService(HttpServletRequest request, HttpServletResponse response) {

    }

    private void buscarPodcastService(HttpServletRequest request, HttpServletResponse response) {

    }

    private void atualziarPodcastService(HttpServletRequest request, HttpServletResponse response) {

    }

    private void salvarEmTurmaService(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        try{
            String nomeTurma = request.getParameter("nomeTurma");
            Podcast podcast = salvarAudio(request,response);
            podcastDao.salvarEmTurma(podcast,nomeTurma);


        } catch (ServletException | IOException e) {
            throw new CommandException(400,"Não foi possível realizar o upload do podcast");
        } catch (DataAccessException e) {
            throw new CommandException(400,"Não foi possível salvar o podcast na base de dados!");
        }

        try {
            response.sendRedirect("pages/turmasvirtuais.jsp");
        } catch (IOException e) {
            throw new CommandException(404,"Não foi possível carregar a página de turmas virtuais");
        }
    }

    private Podcast salvarAudio(HttpServletRequest request, HttpServletResponse repsonse) throws IOException, ServletException {
        String titulo = request.getParameter("titulo");
        String descricao = request.getParameter("descricao");
        String categoria = request.getParameter("categoria");

        //======================================================

        String id = new Double(Math.random()).toString();
        Part part = request.getPart("audio");
        String fileName = id+getFileName(part);
        String uploadImgPath = request.getServletContext().getAttribute("AUDIO_DIR").toString();
        part.write(uploadImgPath + File.separator + fileName);

        //=======================================================

        Podcast podcast = new Podcast();
        podcast.setAudioPath(fileName);
        podcast.setTitulo(titulo);
        podcast.setDescricao(descricao);
        podcast.setCategoria(categoria);
        podcast.setDono((Usuario) request.getSession().getAttribute("usuarioLogado"));
        return podcast;
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


}
