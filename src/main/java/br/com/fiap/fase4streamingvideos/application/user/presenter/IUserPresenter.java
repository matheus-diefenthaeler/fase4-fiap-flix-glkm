package br.com.fiap.fase4streamingvideos.application.user.presenter;

import br.com.fiap.fase4streamingvideos.application.user.exception.UserCustomException;
import br.com.fiap.fase4streamingvideos.application.user.model.response.UserResponseModel;
import br.com.fiap.fase4streamingvideos.application.video.exception.VideoCustomException;

public interface IUserPresenter {
    UserResponseModel prepareFailView(UserCustomException e) throws VideoCustomException;

    UserResponseModel prepareSuccessView(UserResponseModel responseModel);
}
