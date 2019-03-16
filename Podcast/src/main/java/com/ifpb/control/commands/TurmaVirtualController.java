package com.ifpb.control.commands;

import com.ifpb.control.commands.Exceptions.CommandException;
import com.ifpb.model.dao.Exceptions.DataAccessException;
import com.ifpb.model.dao.impl.TurmaVirtualDaoImpl;
import com.ifpb.model.dao.impl.UsuarioDaoImpl;
import com.ifpb.model.dao.interfaces.TurmaVirtualDao;
import com.ifpb.model.dao.interfaces.UsuarioDao;
import com.ifpb.model.domain.TurmaVirtual;
import com.ifpb.model.domain.Usuario;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mailson Dennis
 *
 */
public class TurmaVirtualController implements Command {

    private TurmaVirtualDao turmaVirtualDao;
    private UsuarioDao usuarioDao;

    public TurmaVirtualController(){
        turmaVirtualDao = new TurmaVirtualDaoImpl();
        usuarioDao = new UsuarioDaoImpl();
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


    private void criarTurmaService(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String nomeTurma = request.getParameter("nomeTurma");
        String descricao = request.getParameter("descricao");
        String[] emailAlunos = request.getParameterValues("alunos");
        List<Usuario> alunos = new ArrayList();

        System.out.println(nomeTurma);
        System.out.println(descricao);
        System.out.println(alunos);

        //====================================================

        try{
            for (String email:emailAlunos){
                System.out.println(email);
                alunos.add(usuarioDao.buscar(email));
            }
        } catch (DataAccessException e) {
            throw new CommandException(400,"Não foi possivel adicionar os alunos a turma");
        }

        //====================================================

        TurmaVirtual turma = new TurmaVirtual();
        turma.setNome(nomeTurma);
        turma.setDescricao(descricao);
        turma.setCriador((Usuario)request.getSession().getAttribute("usuarioLogado"));
        turma.setParticipantes(alunos);

        //====================================================

        try {
            turmaVirtualDao.salvar(turma);
        } catch (DataAccessException e) {
            throw new CommandException(400,"Não foi possível concluir a criação da turam virtual");
        }

        request.setAttribute("turmaCriada","turma virtual criada com sucesso!");
        try {
            request.getRequestDispatcher("/pages/turmasvirtuais.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            throw new CommandException(400,"Não foi possível redirecioanr a página de turmas virtuais");
        }


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
