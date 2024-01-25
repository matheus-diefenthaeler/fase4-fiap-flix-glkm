package br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.impl.video;

import br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.repository.IVideoMongoDbRepository;
import br.com.fiap.fase4streamingvideos.application.video.boundaries.output.register.IDeleteVideoGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Component
public class DeleteVideoMongoDbGateway implements IDeleteVideoGateway {
    @Autowired
    IVideoMongoDbRepository _repository;

    public DeleteVideoMongoDbGateway() {}

    @Override
    @Transactional
    public Mono<Void> deleteById(String id) { return _repository.deleteById(id); }
}
