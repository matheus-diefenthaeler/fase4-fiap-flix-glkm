package br.com.fiap.fase4streamingvideos.application.user.boundaries.input;

import br.com.fiap.fase4streamingvideos.application.user.model.response.UserResponseModel;
import reactor.core.publisher.Mono;

public interface IFindByIdUserBoundary {

    Mono<UserResponseModel> findById(String id);
}
