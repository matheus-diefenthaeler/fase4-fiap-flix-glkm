package br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.impl;

import br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.mapper.UserMapper;
import br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.model.UserMongoDB;
import br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.repository.IUserMongoDbRepository;
import br.com.fiap.fase4streamingvideos.application.user.boundaries.output.IUserRegisterGateway;
import br.com.fiap.fase4streamingvideos.application.user.model.response.UserResponseModel;
import br.com.fiap.fase4streamingvideos.domain.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

@Component
public class UserCreationMongoDbGateway implements IUserRegisterGateway {

    @Autowired
    IUserMongoDbRepository repository;

    public UserCreationMongoDbGateway() {
    }
//    @Override
//    public UserResponseModel save(IUser iUser) {
//        UserMongoDB user = new UserMongoDB(iUser.getName(), iUser.getEmail());
//        Mono<UserMongoDB> saveMono = repository.save(user);
//
//        AtomicReference<UserResponseModel> userResponseModelRef = new AtomicReference<>();
//
//        saveMono.subscribe(userMongoDB -> {
//            userResponseModelRef.set(UserMapper.toResponseModel(Mono.just(userMongoDB)).block());
//        });
//
//        return userResponseModelRef.get();
//    }

//    @Override
//    public UserResponseModel save(IUser iUser) {
//        UserMongoDB user = new UserMongoDB(iUser.getName(), iUser.getEmail());
//        Mono<UserMongoDB> saveMono = repository.save(user);
//        //TODO ESTA DANDO ERRO NO SAVE "Cannot autogenerate id of type java.lang.Long for entity of type br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.model.UserMongoDB"
//        AtomicReference<UserResponseModel> userResponseModelRef = new AtomicReference<>();
//
//        saveMono.flatMap(userMongoDB -> Mono.just(UserMapper.toResponseModel(userMongoDB))).subscribe(userResponseModelRef::set);
//
//        return userResponseModelRef.get();
//    }



    @Override
    public UserResponseModel save(IUser iUser) {
        UserMongoDB user = new UserMongoDB(iUser.getName(), iUser.getEmail());
        Mono<UserMongoDB> saveMono = repository.save(user);

        return saveMono
                .flatMap(userMongoDB -> Mono.just(UserMapper.toResponseModel(userMongoDB)))
                .onErrorResume(throwable -> {
                    // Trate erros aqui, se necessário
                    return Mono.empty();
                })
                .toFuture()
                .join(); // Aguarda a conclusão e obtém o resultado
    }




}
