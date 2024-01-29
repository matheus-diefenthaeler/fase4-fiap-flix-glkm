package br.com.fiap.fase4streamingvideos.application.favorite.presenter;

import br.com.fiap.fase4streamingvideos.application.favorite.exception.FavoriteCustomException;
import br.com.fiap.fase4streamingvideos.application.favorite.model.response.FavoriteResponseModel;
import br.com.fiap.fase4streamingvideos.application.video.exception.VideoCustomException;
import br.com.fiap.fase4streamingvideos.application.video.model.response.VideoResponseModel;
import org.reactivestreams.Publisher;
import org.springframework.data.domain.Page;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IFavoritePresenter {
    Mono<FavoriteResponseModel> prepareFailView(FavoriteCustomException e) throws FavoriteCustomException;

    Mono<FavoriteResponseModel> prepareSuccessView(Mono<FavoriteResponseModel> responseModel);

    Flux<Page<VideoResponseModel>> prepareFailViewList(FavoriteCustomException e) throws FavoriteCustomException;

    Flux<Page<FavoriteResponseModel>> prepareSuccessViewList(Flux<Page<FavoriteResponseModel>> model);
}
