package br.com.fiap.fase4streamingvideos.domain.factories;

import br.com.fiap.fase4streamingvideos.domain.IFavorite;

import java.time.LocalDate;

public interface IFavoriteFactory {
    IFavorite create(String idUser, String idVideo, String nameVideo);
}
