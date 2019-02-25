package com.ifpb.model.domain;

import java.io.File;
import java.time.LocalDate;


/**
 *
 * @author Mailson Dennis
 *
 */
public class Professor extends Usuario{

    public Professor() {
    }

    public Professor(String nome, String email, String senha, LocalDate nascimento, Tipo tipo, File foto) {
        super(nome, email, senha, nascimento, tipo, foto);
    }


}
