package com.ifpb.model.domain;

import java.util.Objects;

public class Endereco {

    private String CEP;
    private String estado;
    private String cidade;
    private String rua;
    private String numero;

    public Endereco() {
    }

    public Endereco(String CEP, String estado, String cidade, String rua, String numero) {
        this.CEP = CEP;
        this.estado = estado;
        this.cidade = cidade;
        this.rua = rua;
        this.numero = numero;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return Objects.equals(CEP, endereco.CEP) &&
                Objects.equals(estado, endereco.estado) &&
                Objects.equals(cidade, endereco.cidade) &&
                Objects.equals(rua, endereco.rua) &&
                Objects.equals(numero, endereco.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CEP, estado, cidade, rua, numero);
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "CEP='" + CEP + '\'' +
                ", estado='" + estado + '\'' +
                ", cidade='" + cidade + '\'' +
                ", rua='" + rua + '\'' +
                ", numero='" + numero + '\'' +
                '}';
    }
}
