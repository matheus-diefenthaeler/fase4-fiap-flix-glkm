package br.com.fiap.fase4streamingvideos.application.user.interectors;

import br.com.fiap.fase4streamingvideos.application.user.boundaries.input.IFindByIdUserBoundary;
import br.com.fiap.fase4streamingvideos.application.user.boundaries.output.IUserFindByIdGateway;
import br.com.fiap.fase4streamingvideos.application.user.exception.UserCustomException;
import br.com.fiap.fase4streamingvideos.application.user.model.response.UserResponseModel;
import br.com.fiap.fase4streamingvideos.application.user.presenter.IUserPresenter;
import br.com.fiap.fase4streamingvideos.domain.factories.IUserFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

public class FindByIdUserInteractor implements IFindByIdUserBoundary {

    IUserPresenter presenter;
    IUserFactory factory;
    IUserFindByIdGateway gateway;

    public FindByIdUserInteractor(IUserPresenter presenter, IUserFactory factory, IUserFindByIdGateway gateway) {
        this.presenter = presenter;
        this.factory = factory;
        this.gateway = gateway;
    }

    @Override
    public Mono<UserResponseModel> findById(String id) {
        return gateway.findById(id).switchIfEmpty(Mono.error(new UserCustomException("ID not found!")))
                .onErrorResume(UserCustomException.class, e -> Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage())));
    }
}