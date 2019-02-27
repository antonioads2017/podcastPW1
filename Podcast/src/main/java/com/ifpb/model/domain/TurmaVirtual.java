package com.ifpb.model.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 *
 * @author Mailson Dennis
 *
 */
public class TurmaVirtual {

    private String nome;
    private String descricao;
    private Usuario criador;
    private List<Podcast> podcasts;
    private List<Usuario> participantes;

    public TurmaVirtual() {
        podcasts = new ArrayList<>();
        participantes = new ArrayList<>();
    }

    public TurmaVirtual(String nome, String descricao, Usuario criador, List<Podcast> podcasts, List<Usuario> participantes) {
        this.nome = nome;
        this.descricao = descricao;
        this.criador = criador;
        this.podcasts = podcasts;
        this.participantes = participantes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Usuario getCriador() {
        return criador;
    }

    public void setCriador(Usuario criador) {
        this.criador = criador;
    }

    public List<Podcast> getPodcasts() {
        return podcasts;
    }

    public void setPodcasts(List<Podcast> podcasts) {
        this.podcasts = podcasts;
    }

    public List<Usuario> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Usuario> participantes) {
        this.participantes = participantes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TurmaVirtual that = (TurmaVirtual) o;
        return Objects.equals(nome, that.nome) &&
                Objects.equals(descricao, that.descricao) &&
                Objects.equals(criador, that.criador) &&
                Objects.equals(podcasts, that.podcasts) &&
                Objects.equals(participantes, that.participantes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao, criador, podcasts, participantes);
    }

    @Override
    public String toString() {
        return "TurmaVirtual{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", criador=" + criador +
                ", podcasts=" + podcasts +
                ", participantes=" + participantes +
                '}';
    }
}
