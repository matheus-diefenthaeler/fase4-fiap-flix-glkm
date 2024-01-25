package br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.repository;

import br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.model.VideoMongoDB;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface IVideoMongoDbRepository extends ReactiveMongoRepository<VideoMongoDB, String> {
    Mono<Boolean> existsByTitle(String title);

    Mono<Void> deleteById(String id);

    @Query("{}")
    Flux<VideoMongoDB> findAll(Pageable pageable);
}
