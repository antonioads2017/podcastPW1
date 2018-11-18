package com.ifpb.model.domain;

public class Usuario {

    private String nome;
    private String login;
    private String senha;
    private int idade;

    public Usuario(String nome, String login, String senha, int idade) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.idade = idade;
    }

    public Usuario() {

    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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
                ", login='" + login + '\'' +
                ", idade='" + idade + '\'' +
                '}';
    }
}
