package br.com.fiap.fase4streamingvideos.application.favorite.boundaries.output;

import br.com.fiap.fase4streamingvideos.application.favorite.model.response.FavoriteResponseModel;
import br.com.fiap.fase4streamingvideos.domain.IFavorite;
import reactor.core.publisher.Mono;

public interface ICreateFavoriteGateway extends IFavoriteExistsGateway {
    Mono<FavoriteResponseModel> save(IFavorite iFavorite);
}
