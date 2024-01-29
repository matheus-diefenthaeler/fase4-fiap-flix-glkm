package br.com.fiap.fase4streamingvideos.adapter.presenter;

import br.com.fiap.fase4streamingvideos.application.user.exception.UserCustomException;
import br.com.fiap.fase4streamingvideos.application.user.model.response.UserResponseModel;
import br.com.fiap.fase4streamingvideos.application.user.presenter.IUserPresenter;
import reactor.core.publisher.Mono;

public class UserPresenter implements IUserPresenter {
    @Override
    public Mono<UserResponseModel> prepareFailView(UserCustomException e) throws UserCustomException {
        throw e;
    }

    @Override
    public Mono<UserResponseModel> prepareSuccessView(Mono<UserResponseModel> responseModel) {
        return responseModel;
    }
}
