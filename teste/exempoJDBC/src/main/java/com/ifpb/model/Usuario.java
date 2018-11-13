package com.ifpb.model;

public class Usuario {

    private String nome;
    private String CPF;
    private int idade;

    public Usuario(String cpf, String nome, int idade) {
        this.nome = nome;
        this.CPF = cpf;
        this.idade = idade;
    }

    public Usuario(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", CPF='" + CPF + '\'' +
                ", idade=" + idade +
                '}';
    }
}

