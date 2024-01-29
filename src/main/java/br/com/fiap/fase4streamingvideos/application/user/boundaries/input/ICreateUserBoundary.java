package br.com.fiap.fase4streamingvideos.application.user.boundaries.input;

import br.com.fiap.fase4streamingvideos.application.user.exception.UserCustomException;
import br.com.fiap.fase4streamingvideos.application.user.model.request.UserRequestModel;
import br.com.fiap.fase4streamingvideos.application.user.model.response.UserResponseModel;
import reactor.core.publisher.Mono;

public interface ICreateUserBoundary {

    Mono<UserResponseModel> create(UserRequestModel requestModel) throws UserCustomException;
}
