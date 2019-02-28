package com.ifpb.model.domain;


import com.ifpb.model.domain.Enum.NivelAcesso;
import com.ifpb.model.domain.Enum.Sexo;
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
    private NivelAcesso nivelAcesso;
    private File foto;
    private Sexo sexo;
    private String telefone;
    private Endereco endereco;

    public Usuario() {
    }

    public Usuario(String nome, String email, String senha, LocalDate nascimento, Tipo tipo, NivelAcesso nivelAcesso, File foto, Sexo sexo, String telefone, Endereco endereco) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.nascimento = nascimento;
        this.tipo = tipo;
        this.nivelAcesso = nivelAcesso;
        this.foto = foto;
        this.sexo = sexo;
        this.telefone = telefone;
        this.endereco = endereco;
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

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public NivelAcesso getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(NivelAcesso nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
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
                nivelAcesso == usuario.nivelAcesso &&
                Objects.equals(foto, usuario.foto) &&
                sexo == usuario.sexo &&
                Objects.equals(telefone, usuario.telefone) &&
                Objects.equals(endereco, usuario.endereco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, email, senha, nascimento, tipo, nivelAcesso, foto, sexo, telefone, endereco);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", nascimento=" + nascimento +
                ", tipo=" + tipo +
                ", nivelAcesso=" + nivelAcesso +
                ", foto=" + foto +
                ", sexo=" + sexo +
                ", telefone='" + telefone + '\'' +
                ", endereco=" + endereco +
                '}';
    }
}
