package br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.impl.user;

import br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.repository.IUserMongoDbRepository;
import br.com.fiap.fase4streamingvideos.application.user.boundaries.output.IUserDeleteGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Component
public class UserDeleteMongoDbGateway implements IUserDeleteGateway {

    @Autowired
    IUserMongoDbRepository repository;

    public UserDeleteMongoDbGateway() {
    }

    @Override
    @Transactional
    public Mono<Void> deleteByEmail(String email) {
        return repository.deleteByEmail(email);
    }

    @Override
    public Mono<Boolean> existsByEmail(String email) {
        return repository.existsByEmail(email);
    }
}
