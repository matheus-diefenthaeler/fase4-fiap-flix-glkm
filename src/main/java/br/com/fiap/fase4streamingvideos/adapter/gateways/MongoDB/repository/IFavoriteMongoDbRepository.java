package br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.repository;

import br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.model.FavoriteMongoDB;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface IFavoriteMongoDbRepository extends ReactiveMongoRepository<FavoriteMongoDB, String> {
    Mono<Boolean> existsByIdVideoAndIdUser(String idVideo, String idUser);

    Flux<FavoriteMongoDB> findAllByIdUser(String id);
}
