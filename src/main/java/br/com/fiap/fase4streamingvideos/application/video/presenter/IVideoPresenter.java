package br.com.fiap.fase4streamingvideos.application.video.presenter;

import br.com.fiap.fase4streamingvideos.application.video.exception.VideoCustomException;
import br.com.fiap.fase4streamingvideos.application.video.model.response.VideoResponseModel;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IVideoPresenter {
    VideoResponseModel prepareFailView(VideoCustomException e) throws VideoCustomException;
    VideoResponseModel prepareSuccessView(VideoResponseModel responseModel);
    List<VideoResponseModel> prepareFailViewList(VideoCustomException e) throws VideoCustomException;
    List<VideoResponseModel> prepareSuccessViewList(List<VideoResponseModel> model);
}
