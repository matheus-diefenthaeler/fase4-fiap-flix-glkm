package br.com.fiap.fase4streamingvideos.application.user.interectors;

import br.com.fiap.fase4streamingvideos.application.user.boundaries.input.IFindAllUserBoundary;
import br.com.fiap.fase4streamingvideos.application.user.boundaries.output.IUserFindGateway;
import br.com.fiap.fase4streamingvideos.application.user.model.response.UserResponseModel;
import br.com.fiap.fase4streamingvideos.application.user.presenter.IUserPresenter;
import br.com.fiap.fase4streamingvideos.domain.factories.IUserFactory;
import reactor.core.publisher.Flux;

public class FindAllUserInteractor implements IFindAllUserBoundary {

    IUserPresenter presenter;
    IUserFactory factory;
    IUserFindGateway gateway;

    public FindAllUserInteractor(IUserPresenter presenter, IUserFactory factory, IUserFindGateway gateway) {
        this.presenter = presenter;
        this.factory = factory;
        this.gateway = gateway;
    }


    @Override
    public Flux<UserResponseModel> findAll() {
        return gateway.findAll();
    }
}