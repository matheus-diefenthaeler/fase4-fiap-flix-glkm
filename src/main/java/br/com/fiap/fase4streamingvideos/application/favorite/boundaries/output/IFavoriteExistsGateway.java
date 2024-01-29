package br.com.fiap.fase4streamingvideos.application.favorite.boundaries.output;

import reactor.core.publisher.Mono;

public interface IFavoriteExistsGateway {
    Mono<Boolean> existsByIdVideoAndIdUser(String idVideo, String idUser);
}
