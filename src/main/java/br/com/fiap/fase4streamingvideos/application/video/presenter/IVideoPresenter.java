package br.com.fiap.fase4streamingvideos.application.video.presenter;

import br.com.fiap.fase4streamingvideos.application.video.exception.VideoCustomException;
import br.com.fiap.fase4streamingvideos.application.video.model.response.VideoResponseModel;

public interface IVideoPresenter {

    VideoResponseModel prepareFailView(VideoCustomException e) throws VideoCustomException;

    VideoResponseModel prepareSuccessView(VideoResponseModel responseModel);
}
