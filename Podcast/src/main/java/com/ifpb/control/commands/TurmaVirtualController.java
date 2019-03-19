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
 * @author Mailson Dennis
 */
public class TurmaVirtualController implements Command {

    private TurmaVirtualDao turmaVirtualDao;
    private UsuarioDao usuarioDao;

    public TurmaVirtualController() {
        turmaVirtualDao = new TurmaVirtualDaoImpl();
        usuarioDao = new UsuarioDaoImpl();
    }


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String acao = request.getParameter("acao");
        switch (acao) {
            case "criar":
                criarTurmaService(request, response);
                break;
            case "deletar":
                deletarTurmaService(request, response);
                break;
            case "listar":
                listarTurmaService(request, response);
                break;
            case "buscar":
                buscarTurmaService(request, response);
                break;
            case "atualizar":
                atualizarTurmaService(request, response);
                break;
            case "adicionarMembro":
                adicionarMembroService(request, response);
                break;
            case "removerMembro":
                removerMembroService(request,response);
                break;
            case "adicionarPodcast":
                adicioanarPodcastService(request, response);
                break;
        }
    }


    private void criarTurmaService(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String nomeTurma = request.getParameter("nomeTurma");
        String descricao = request.getParameter("descricao");
        String[] emailAlunos = request.getParameterValues("alunos");
        List<Usuario> alunos;
        //====================================================

        try {
            alunos = adicionarAlunos(emailAlunos);
        } catch (DataAccessException e) {
            throw new CommandException(400, "Não foi possivel adicionar os alunos a turma");
        }

        //====================================================

        TurmaVirtual turma = new TurmaVirtual();
        turma.setNome(nomeTurma);
        turma.setDescricao(descricao);
        turma.setCriador((Usuario) request.getSession().getAttribute("usuarioLogado"));
        turma.setParticipantes(alunos);

        //====================================================

        try {
            turmaVirtualDao.salvar(turma);
        } catch (DataAccessException e) {
            throw new CommandException(400, "Não foi possível concluir a criação da turma virtual");
        }

        request.setAttribute("turmaCriada", "turma virtual criada com sucesso!");
        try {
            response.sendRedirect("/pages/turmasvirtuais.jsp");
        } catch (IOException e) {
            throw new CommandException(400, "Não foi possível redirecioanr a página de turmas virtuais");
        }


    }

    private void deletarTurmaService(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String nomeTurma = request.getParameter("nomeTurma");

        if(nomeTurma.split("_").length>1){
            nomeTurma = nomeTurma.replace("_"," ");
        }

        try {
            turmaVirtualDao.remover(nomeTurma);
            response.sendRedirect("/pages/turmasvirtuais.jsp");
        } catch (DataAccessException e) {
            throw new CommandException(400, "Falha na exclusão da turma");
        } catch (IOException e) {
            throw new CommandException(404, "Falha ao recarregar a página de turmas virtuais");
        }

    }

    private void listarTurmaService(HttpServletRequest request, HttpServletResponse response) {


    }

    private void buscarTurmaService(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String nomeTurma = request.getParameter("nomeTurma");

        if(nomeTurma.split("_").length>1){
            nomeTurma = nomeTurma.replace("_"," ");
        }

        TurmaVirtual turma;

        try {
            turma = turmaVirtualDao.buscar(nomeTurma);
        } catch (DataAccessException e) {
            throw new CommandException(400, "Não foi possível carregar a página para a turma requisitada");
        }

        request.setAttribute("turma", turma);
        try {
            request.getRequestDispatcher("/pages/perfilturma.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            throw new CommandException(400, "Falha ao abrir a página da turma");
        }
    }

    private void adicionarMembroService(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String emailAluno = request.getParameter("alunoEmail");
        String nomeTurma = request.getParameter("nomeTurma");

        if(nomeTurma.split("_").length>1){
            nomeTurma = nomeTurma.replace("_"," ");
        }

        if(emailAluno != null && nomeTurma!=null){
            try {
                turmaVirtualDao.adicionarAlunoaTurma(nomeTurma,emailAluno);
            } catch (DataAccessException e) {
                throw new CommandException(400, "Falha ao adicionar o aluno a turma");
            }
            request.setAttribute("msg","Aluno adicionado com sucesso!");
        }
        try {
            response.sendRedirect("/pages/turmasvirtuais.jsp");
        } catch (IOException e) {
            throw new CommandException(400, "Falha ao abrir a página das turmas");
        }

    }

    private void removerMembroService(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String emailAluno = request.getParameter("emailAluno");
        String nomeTurma = request.getParameter("nomeTurma");

        if(nomeTurma.split("_").length>1){
            nomeTurma = nomeTurma.replace("_"," ");
        }

        try {
            turmaVirtualDao.removerAlunodeTurma(nomeTurma,emailAluno);
        } catch (DataAccessException e) {
            throw new CommandException(400,"Falha ao remover o aluno da turma!");
        }

        try {
            response.sendRedirect("/inicio?comando=TurmaVirtualController&acao=buscar&nomeTurma="+nomeTurma);
        } catch (IOException e) {
            throw new CommandException(404,"Falha ao recarregar a pagina da turma!");
        }
    }

    private void adicioanarPodcastService(HttpServletRequest request, HttpServletResponse response) {
        //TODO
    }

    private void atualizarTurmaService(HttpServletRequest request, HttpServletResponse response) {
        //TODO
    }

    private List<Usuario> adicionarAlunos(String[] emailAlunos) throws DataAccessException {
        List<Usuario> alunos = new ArrayList();
        for (String email : emailAlunos) {
            System.out.println(email);
            alunos.add(usuarioDao.buscar(email));
        }
        return alunos;

    }


}
