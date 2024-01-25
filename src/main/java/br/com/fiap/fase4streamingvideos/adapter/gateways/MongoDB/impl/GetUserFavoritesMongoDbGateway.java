package br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.impl;

import br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.model.VideoMongoDB;
import br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.repository.IUserMongoDbRepository;
import br.com.fiap.fase4streamingvideos.application.user.boundaries.output.IGetUserFavoritesGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GetUserFavoritesMongoDbGateway implements IGetUserFavoritesGateway {

    @Autowired
    IUserMongoDbRepository repository;

    public GetUserFavoritesMongoDbGateway() {
    }

    @Override
    public Flux<String> getFavorites(String id) {
        return repository.findById(id)
                .flatMapMany(userMongoDB -> Flux.fromIterable(userMongoDB.getFavoriteVideos()))
                .map(VideoMongoDB::getTitle)
                .switchIfEmpty(Flux.empty()); // Retorna um Flux vazio se o usuário não for encontrado
    }
}
