package br.com.fiap.fase4streamingvideos.adapter.presenter;

import br.com.fiap.fase4streamingvideos.application.video.exception.VideoCustomException;
import br.com.fiap.fase4streamingvideos.application.video.model.response.VideoResponseModel;
import br.com.fiap.fase4streamingvideos.application.video.presenter.IVideoPresenter;
import org.springframework.data.domain.Page;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class VideoPresenter implements IVideoPresenter {
    @Override
    public Mono<VideoResponseModel> prepareFailView(VideoCustomException e) throws VideoCustomException {
        throw e;
    }

    @Override
    public Mono<VideoResponseModel> prepareSuccessView(Mono<VideoResponseModel> responseModel) {
        return responseModel;
    }

    @Override
    public Flux<Page<VideoResponseModel>> prepareFailViewList(VideoCustomException e) throws VideoCustomException {
        throw e;
    }

    @Override
    public Flux<Page<VideoResponseModel>> prepareSuccessViewList(Flux<Page<VideoResponseModel>> model) {
        return model;
    }
}
