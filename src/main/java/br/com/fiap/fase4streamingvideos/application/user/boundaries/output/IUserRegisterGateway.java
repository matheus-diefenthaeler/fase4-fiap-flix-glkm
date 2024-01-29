package br.com.fiap.fase4streamingvideos.application.user.boundaries.output;

import br.com.fiap.fase4streamingvideos.application.user.model.response.UserResponseModel;
import br.com.fiap.fase4streamingvideos.domain.IUser;
import reactor.core.publisher.Mono;

public interface IUserRegisterGateway extends IUserExistsGateway {
    Mono<UserResponseModel> save(IUser iUser);
}
