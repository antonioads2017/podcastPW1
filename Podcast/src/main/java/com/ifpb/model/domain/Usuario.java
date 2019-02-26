package com.ifpb.model.domain;


import com.ifpb.model.domain.Enum.Tipo;

import java.io.File;
import java.time.LocalDate;
import java.util.Objects;


/**
 *
 * @author Mailson Dennis
 *
 */

public class Usuario {

    private String nome;
    private String email;
    private String senha;
    private LocalDate nascimento;
    private Tipo tipo;
    private File foto;

    public Usuario() {
    }

    public Usuario(String nome, String email, String senha, LocalDate nascimento, Tipo tipo, File foto) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.nascimento = nascimento;
        this.tipo = tipo;
        this.foto = foto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public File getFoto() {
        return foto;
    }

    public void setFoto(File foto) {
        this.foto = foto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(nome, usuario.nome) &&
                Objects.equals(email, usuario.email) &&
                Objects.equals(senha, usuario.senha) &&
                Objects.equals(nascimento, usuario.nascimento) &&
                tipo == usuario.tipo &&
                Objects.equals(foto, usuario.foto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, email, senha, nascimento, tipo, foto);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", nascimento=" + nascimento +
                ", tipo=" + tipo +
                ", foto=" + foto +
                '}';
    }
}
