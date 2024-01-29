package br.com.fiap.fase4streamingvideos.application.video.model.response;

import java.util.Objects;

public class VideoResponseModel {
    private String id;
    private String titulo;
    private String descricao;
    private String url;
    private String createdAt;

    private String category;

    private Long views;

    public VideoResponseModel() {
    }

    public VideoResponseModel(String titulo, String descricao, String url, String createdAt, String category) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.url = url;
        this.createdAt = createdAt;
        this.category = category;
        this.views = 0L;
    }

    public Long getViews() {
        return views;
    }

    public void setViews(Long views) {
        this.views = views;
    }

    public String getId() {
        return id;
    }

    public VideoResponseModel setId(String id) {
        this.id = id;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public VideoResponseModel setCategory(String category) {
        this.category = category;
        return this;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VideoResponseModel that = (VideoResponseModel) o;
        return Objects.equals(titulo, that.titulo) && Objects.equals(descricao, that.descricao) && Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, descricao, url);
    }
}
