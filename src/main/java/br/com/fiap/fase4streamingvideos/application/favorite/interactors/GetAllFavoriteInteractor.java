package br.com.fiap.fase4streamingvideos.application.favorite.interactors;

import br.com.fiap.fase4streamingvideos.application.favorite.boundaries.input.IGetAllFavoriteBoundary;
import br.com.fiap.fase4streamingvideos.application.favorite.boundaries.output.IGetAllFavoriteGateway;
import br.com.fiap.fase4streamingvideos.application.favorite.exception.FavoriteCustomException;
import br.com.fiap.fase4streamingvideos.application.favorite.model.response.FavoriteResponseModel;
import br.com.fiap.fase4streamingvideos.application.favorite.presenter.IFavoritePresenter;
import br.com.fiap.fase4streamingvideos.application.user.boundaries.input.IFindByIdUserBoundary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;

public class GetAllFavoriteInteractor implements IGetAllFavoriteBoundary {
    IFavoritePresenter presenter;
    IGetAllFavoriteGateway gateway;

    public GetAllFavoriteInteractor(IFavoritePresenter presenter, IGetAllFavoriteGateway gateway) {
        this.presenter = presenter;
        this.gateway = gateway;
    }
    @Override
    public Flux<FavoriteResponseModel> findAllByIdUser(String id) throws FavoriteCustomException {
        return gateway.findAllByIdUser(id)
                .collectList()
                .flatMapMany(favoriteList -> {
                    if (favoriteList.isEmpty()) {
                        return Flux.error(new FavoriteCustomException("Favorites not found"));
                    } else {
                        return Flux.fromIterable(favoriteList);
                    }
                });
    }
}
