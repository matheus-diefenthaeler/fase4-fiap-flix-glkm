package br.com.fiap.fase4streamingvideos.adapter.presenter;

import br.com.fiap.fase4streamingvideos.application.video.exception.VideoCustomException;
import br.com.fiap.fase4streamingvideos.application.video.model.response.VideoResponseModel;
import br.com.fiap.fase4streamingvideos.application.video.presenter.IVideoPresenter;
import org.springframework.cglib.core.Local;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

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

    @Override
    public Page<VideoResponseModel> prepareFailViewList(VideoCustomException e) throws VideoCustomException {
        throw e;
    }

    @Override
    public Page<VideoResponseModel> prepareSuccessViewList(Page<VideoResponseModel> model) {
        return model;
    }

    @Override
    public String prepareSuccessViewStatus(String status) {
        return status;
    }
}
