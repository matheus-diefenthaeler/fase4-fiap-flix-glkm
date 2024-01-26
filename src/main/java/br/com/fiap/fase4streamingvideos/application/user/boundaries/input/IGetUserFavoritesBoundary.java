package br.com.fiap.fase4streamingvideos.application.user.boundaries.input;

import reactor.core.publisher.Flux;

public interface IGetUserFavoritesBoundary {

    Flux<?> getFavorites(String id);
}
