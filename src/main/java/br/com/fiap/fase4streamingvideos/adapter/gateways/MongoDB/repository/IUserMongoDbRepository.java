package br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.repository;

import br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.model.UserMongoDB;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface IUserMongoDbRepository extends ReactiveMongoRepository<UserMongoDB, String> {
    Mono<UserMongoDB> findByName(String name);

    Mono<Boolean> existsByEmail(String email);

    Flux<UserMongoDB> findAll();

    Mono<Void> deleteByEmail(String email);
}
