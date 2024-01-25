package br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.impl.user;

import br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.mapper.UserMapper;
import br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.repository.IUserMongoDbRepository;
import br.com.fiap.fase4streamingvideos.application.user.boundaries.output.IUserFindGateway;
import br.com.fiap.fase4streamingvideos.application.user.model.response.UserResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class UserFindMongoDbGateway implements IUserFindGateway {

    @Autowired
    IUserMongoDbRepository repository;

    public UserFindMongoDbGateway() {
    }

    @Override
    public Flux<UserResponseModel> findAll() {
        return UserMapper.toFluxResponseModel(repository.findAll());
    }
}
