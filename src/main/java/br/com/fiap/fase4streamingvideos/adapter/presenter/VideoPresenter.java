package br.com.fiap.fase4streamingvideos.adapter.presenter;

import br.com.fiap.fase4streamingvideos.application.video.exception.VideoCustomException;
import br.com.fiap.fase4streamingvideos.application.video.model.response.VideoResponseModel;
import br.com.fiap.fase4streamingvideos.application.video.presenter.IVideoPresenter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class VideoPresenter implements IVideoPresenter {
    @Override
    public VideoResponseModel prepareFailView(VideoCustomException e) throws VideoCustomException {
        throw e;
    }

    @Override
    public VideoResponseModel prepareSuccessView(VideoResponseModel responseModel) {
        LocalDate responseTime = LocalDate.parse(responseModel.getCreatedAt());
        responseModel.setCreatedAt(responseTime.format(DateTimeFormatter.ISO_LOCAL_DATE));
        return responseModel;
    }
}
