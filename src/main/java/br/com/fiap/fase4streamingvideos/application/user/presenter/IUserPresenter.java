package br.com.fiap.fase4streamingvideos.application.user.presenter;

import br.com.fiap.fase4streamingvideos.application.user.exception.UserCustomException;
import br.com.fiap.fase4streamingvideos.application.user.model.response.UserResponseModel;
import br.com.fiap.fase4streamingvideos.application.video.exception.VideoCustomException;
import reactor.core.publisher.Mono;

public interface IUserPresenter {
    Mono<UserResponseModel> prepareFailView(UserCustomException e) throws VideoCustomException;

    Mono<UserResponseModel> prepareSuccessView(Mono<UserResponseModel> responseModel);
}
