package br.com.fiap.fase4streamingvideos.adapter.presenter;

import br.com.fiap.fase4streamingvideos.application.favorite.exception.FavoriteCustomException;
import br.com.fiap.fase4streamingvideos.application.favorite.model.response.FavoriteResponseModel;
import br.com.fiap.fase4streamingvideos.application.favorite.presenter.IFavoritePresenter;
import br.com.fiap.fase4streamingvideos.application.video.exception.VideoCustomException;
import br.com.fiap.fase4streamingvideos.application.video.model.response.VideoResponseModel;
import org.springframework.data.domain.Page;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class FavoritePresenter implements IFavoritePresenter {
    @Override
    public Mono<FavoriteResponseModel> prepareFailView(FavoriteCustomException e) throws FavoriteCustomException {
        throw e;
    }

    @Override
    public Mono<FavoriteResponseModel> prepareSuccessView(Mono<FavoriteResponseModel> responseModel) {
        return responseModel;
    }

    @Override
    public Flux<Page<VideoResponseModel>> prepareFailViewList(FavoriteCustomException e) throws FavoriteCustomException {
        throw e;
    }

    @Override
    public Flux<Page<FavoriteResponseModel>> prepareSuccessViewList(Flux<Page<FavoriteResponseModel>> favoriteList) {
        return favoriteList;
    }
}
