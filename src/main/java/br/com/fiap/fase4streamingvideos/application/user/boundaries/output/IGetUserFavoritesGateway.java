package br.com.fiap.fase4streamingvideos.application.user.boundaries.output;

import br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.model.VideoMongoDB;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface IGetUserFavoritesGateway {

    Flux<String> getFavorites(String id);

}
