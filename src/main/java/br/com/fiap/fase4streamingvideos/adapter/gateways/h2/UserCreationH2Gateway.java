//package br.com.fiap.fase4streamingvideos.adapter.gateways.h2;
//
//import br.com.fiap.fase4streamingvideos.adapter.gateways.mapper.UserJpaMapper;
//import br.com.fiap.fase4streamingvideos.adapter.gateways.mapper.UserMapper;
//import br.com.fiap.fase4streamingvideos.adapter.repository.IUserRepository;
//import br.com.fiap.fase4streamingvideos.application.user.boundaries.output.IUserRegisterGateway;
//import br.com.fiap.fase4streamingvideos.application.user.model.response.UserResponseModel;
//import br.com.fiap.fase4streamingvideos.domain.IUser;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import reactor.core.publisher.Mono;
//
//@Component
//public class UserCreationH2Gateway implements IUserRegisterGateway {
//
//    @Autowired
//    IUserRepository repository;
//
//    public UserCreationH2Gateway() {
//    }
//
//
//    @Override
//    public Mono<UserResponseModel> save(IUser iUser) {
//        UserJpaMapper userJpaMapper = new UserJpaMapper(iUser.getName(), iUser.getEmail());
//
//        return  repository.save(userJpaMapper);
//
////        return UserMapper.toRespondeModel(userJpaMapper);
//    }
//
//    @Override
//    public boolean existsByEmail(String email) {
//        return this.repository.existsByEmail(email);
//    }
//}
