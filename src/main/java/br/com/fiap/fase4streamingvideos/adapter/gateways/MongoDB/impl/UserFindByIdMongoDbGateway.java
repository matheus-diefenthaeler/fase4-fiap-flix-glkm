package br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.impl;

import br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.mapper.UserMapper;
import br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.repository.IUserMongoDbRepository;
import br.com.fiap.fase4streamingvideos.application.user.boundaries.output.IUserFindByIdGateway;
import br.com.fiap.fase4streamingvideos.application.user.model.response.UserResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class UserFindByIdMongoDbGateway implements IUserFindByIdGateway {

    @Autowired
    IUserMongoDbRepository repository;

    public UserFindByIdMongoDbGateway() {
    }

    @Override
    public Mono<UserResponseModel> findById(String id) {
        return UserMapper.toResponseModel(repository.findById(id));
    }
}
