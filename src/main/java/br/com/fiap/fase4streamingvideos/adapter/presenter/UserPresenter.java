package br.com.fiap.fase4streamingvideos.adapter.presenter;

import br.com.fiap.fase4streamingvideos.application.user.exception.UserCustomException;
import br.com.fiap.fase4streamingvideos.application.user.model.response.UserResponseModel;
import br.com.fiap.fase4streamingvideos.application.user.presenter.IUserPresenter;

public class UserPresenter implements IUserPresenter {
    @Override
    public UserResponseModel prepareFailView(UserCustomException e) throws UserCustomException {
        throw e;
    }

    @Override
    public UserResponseModel prepareSuccessView(UserResponseModel responseModel) {
        return responseModel;
    }
}
