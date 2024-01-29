package br.com.fiap.fase4streamingvideos.application.favorite.boundaries.input;

import br.com.fiap.fase4streamingvideos.application.favorite.exception.FavoriteCustomException;
import br.com.fiap.fase4streamingvideos.application.favorite.model.request.FavoriteRequestModel;
import br.com.fiap.fase4streamingvideos.application.favorite.model.response.FavoriteResponseModel;
import reactor.core.publisher.Mono;

public interface ICreateFavoriteBoundary {
    Mono<FavoriteResponseModel> create(FavoriteRequestModel requestModel) throws FavoriteCustomException;
}
