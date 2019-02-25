package com.ifpb.model.domain;

import java.util.Objects;

public class Comentario {

    private Usuario usuario;
    private String texto;


    public Comentario() {

    }

    public Comentario(Usuario usuario, String texto) {
        this.usuario = usuario;
        this.texto = texto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comentario that = (Comentario) o;
        return Objects.equals(usuario, that.usuario) &&
                Objects.equals(texto, that.texto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuario, texto);
    }

    @Override
    public String toString() {
        return "Comentario{" +
                "usuario=" + usuario +
                ", texto='" + texto + '\'' +
                '}';
    }
}
