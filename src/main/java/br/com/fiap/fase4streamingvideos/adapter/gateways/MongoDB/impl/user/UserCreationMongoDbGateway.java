package br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.impl.user;

import br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.mapper.UserMapper;
import br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.model.UserMongoDB;
import br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.repository.IUserMongoDbRepository;
import br.com.fiap.fase4streamingvideos.application.user.boundaries.output.IUserRegisterGateway;
import br.com.fiap.fase4streamingvideos.application.user.model.response.UserResponseModel;
import br.com.fiap.fase4streamingvideos.domain.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class UserCreationMongoDbGateway implements IUserRegisterGateway {

    @Autowired
    IUserMongoDbRepository repository;

    public UserCreationMongoDbGateway() {}

    @Override
    public Mono<UserResponseModel> save(IUser iUser) {
        UserMongoDB user = new UserMongoDB(iUser.getName(), iUser.getEmail());
        Mono<UserMongoDB> saveMono = repository.save(user);
        return UserMapper.toResponseModel(saveMono);
    }

    @Override
    public Mono<Boolean> existsByEmail(String email) {
        return repository.existsByEmail(email);
    }

}
