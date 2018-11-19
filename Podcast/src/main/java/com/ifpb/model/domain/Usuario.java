package com.ifpb.model.domain;

import java.time.LocalDate;
import java.util.Objects;

public class Usuario {

    private String nome;
    private String email;
    private String senha;
    private String nascimento;

    public Usuario(String nome, String Email, String senha, String nascimento) {
        this.nome = nome;
        this.email = Email;
        this.senha = senha;
        this.nascimento = nascimento;
    }

    public Usuario() {

    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
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

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", Email='" + email + '\'' +
                ", nascimento='" + nascimento + '\'' +
                '}';
    }

    public boolean autentication(String email, String senha){

        return Objects.equals(email,this.email) && Objects.equals(senha,this.senha);

    }
}
