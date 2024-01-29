package br.com.fiap.fase4streamingvideos.application.user.boundaries.output;

import br.com.fiap.fase4streamingvideos.application.user.model.response.UserResponseModel;
import reactor.core.publisher.Mono;

public interface IUserFindByIdGateway {

    Mono<UserResponseModel> findById(String id);

}
