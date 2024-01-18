package br.com.fiap.fase4streamingvideos.application.video.presenter;

import br.com.fiap.fase4streamingvideos.application.video.exception.VideoCustomException;
import br.com.fiap.fase4streamingvideos.application.video.model.response.VideoResponseModel;
import org.springframework.data.domain.Page;

public interface IVideoPresenter {
    VideoResponseModel prepareFailView(VideoCustomException e) throws VideoCustomException;
    VideoResponseModel prepareSuccessView(VideoResponseModel responseModel);
    Page<VideoResponseModel> prepareFailViewList(VideoCustomException e) throws VideoCustomException;
    Page<VideoResponseModel> prepareSuccessViewList(Page<VideoResponseModel> model);

    String prepareSuccessViewStatus(String string);
}
