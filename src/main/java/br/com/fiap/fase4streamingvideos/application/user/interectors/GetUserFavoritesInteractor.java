package br.com.fiap.fase4streamingvideos.application.user.interectors;

import br.com.fiap.fase4streamingvideos.application.user.boundaries.input.IGetUserFavoritesBoundary;
import br.com.fiap.fase4streamingvideos.application.user.boundaries.output.IGetUserFavoritesGateway;
import br.com.fiap.fase4streamingvideos.application.user.presenter.IUserPresenter;
import br.com.fiap.fase4streamingvideos.domain.factories.IUserFactory;
import reactor.core.publisher.Flux;

public class GetUserFavoritesInteractor implements IGetUserFavoritesBoundary {

    IUserPresenter presenter;
    IUserFactory factory;
    IGetUserFavoritesGateway gateway;

    public GetUserFavoritesInteractor(IUserPresenter presenter, IUserFactory factory, IGetUserFavoritesGateway gateway) {
        this.presenter = presenter;
        this.factory = factory;
        this.gateway = gateway;
    }


    @Override
    public Flux<?> getFavorites(String id) {
        return gateway.getFavorites(id);
    }
}