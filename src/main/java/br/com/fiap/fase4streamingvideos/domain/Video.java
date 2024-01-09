package br.com.fiap.fase4streamingvideos.domain;

import java.time.LocalDate;

public class Video implements IVideo {

    private String titulo;
    private String descricao;
    private String url;
    private LocalDate dataPublicacao;

    private String category;

    public Video(String titulo, String descricao, String url, LocalDate dataPublicacao, String category) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.url = url;
        this.dataPublicacao = dataPublicacao;
        this.category=category;
    }

    @Override
    public String getTitulo() {
        return titulo;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    @Override
    public String getCategory() {
        return category;
    }
}
