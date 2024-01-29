package br.com.fiap.fase4streamingvideos.domain.factories;

import br.com.fiap.fase4streamingvideos.domain.Favorite;
import br.com.fiap.fase4streamingvideos.domain.IFavorite;
import br.com.fiap.fase4streamingvideos.domain.User;

import java.time.LocalDate;

public class FavoriteFactory implements IFavoriteFactory{
    @Override
    public Favorite create(String idUser, String idVideo, String nameVideo) {
        return new Favorite(idUser, idVideo, nameVideo);
    }
}
