package br.com.fiap.fase4streamingvideos.domain;

import java.time.LocalDate;

public interface IVideo {

    String getTitulo();
    String getDescricao();
    String getUrl();
    LocalDate getDataPublicacao();
    String getCategory();
}
