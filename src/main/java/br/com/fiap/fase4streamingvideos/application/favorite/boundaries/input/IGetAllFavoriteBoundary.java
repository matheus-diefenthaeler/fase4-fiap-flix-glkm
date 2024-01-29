package br.com.fiap.fase4streamingvideos.application.favorite.boundaries.input;

import br.com.fiap.fase4streamingvideos.application.favorite.model.response.FavoriteResponseModel;
import reactor.core.publisher.Flux;

public interface IGetAllFavoriteBoundary {
    Flux<FavoriteResponseModel> findAllByIdUser(String id);
}
