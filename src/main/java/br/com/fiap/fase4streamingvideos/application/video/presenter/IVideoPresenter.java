package br.com.fiap.fase4streamingvideos.application.video.presenter;

import br.com.fiap.fase4streamingvideos.application.video.exception.VideoCustomException;
import br.com.fiap.fase4streamingvideos.application.video.model.response.VideoResponseModel;
import org.springframework.data.domain.Page;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IVideoPresenter {
    Mono<VideoResponseModel> prepareFailView(VideoCustomException e) throws VideoCustomException;
    Mono<VideoResponseModel> prepareSuccessView(Mono<VideoResponseModel> responseModel);
    Flux<Page<VideoResponseModel>> prepareFailViewList(VideoCustomException e) throws VideoCustomException;
    Flux<Page<VideoResponseModel>> prepareSuccessViewList(Flux<Page<VideoResponseModel>> model);
}
