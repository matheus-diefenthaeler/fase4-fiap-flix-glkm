package br.com.fiap.fase4streamingvideos.domain;

import java.time.LocalDate;

public interface IFavorite {
    String getIdUser();

    String getIdVideo();

    String getNameVideo();

    LocalDate getAddedAt();
}
