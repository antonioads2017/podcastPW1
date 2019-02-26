package com.ifpb.model.dao.interfaces;

import com.ifpb.model.dao.Exceptions.DataAccessException;
import com.ifpb.model.domain.Comentario;

import java.util.List;

/**
 *
 * @author Mailson Dennis
 *
 */
public interface ComentarioDao {
    void salvar(Comentario comentario,String podcast) throws DataAccessException;
    void deletar(String usuario, String podcast) throws DataAccessException;
    void deletarPorPodcast(String podcast) throws DataAccessException;
    List<Comentario> buscarPorPodcast(String podcast) throws DataAccessException;

}
