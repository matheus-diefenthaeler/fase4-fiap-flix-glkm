package br.com.fiap.fase4streamingvideos.application.user.interectors;

import br.com.fiap.fase4streamingvideos.application.user.boundaries.input.IDeleteUserBoundary;
import br.com.fiap.fase4streamingvideos.application.user.boundaries.output.IUserDeleteGateway;
import br.com.fiap.fase4streamingvideos.application.user.exception.UserCustomException;
import br.com.fiap.fase4streamingvideos.application.user.presenter.IUserPresenter;
import br.com.fiap.fase4streamingvideos.domain.factories.IUserFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

public class DeleteUserInteractor implements IDeleteUserBoundary {

    IUserPresenter presenter;
    IUserFactory factory;
    IUserDeleteGateway gateway;

    public DeleteUserInteractor(IUserPresenter presenter, IUserFactory factory, IUserDeleteGateway gateway) {
        this.presenter = presenter;
        this.factory = factory;
        this.gateway = gateway;
    }

    @Override
    public Mono<Void> deleteByEmail(String email) {
        return gateway.existsByEmail(email)
                .flatMap(emailExists -> emailExists
                        ? gateway.deleteByEmail(email).then()
                        : Mono.error(new UserCustomException("Email not found in database")));
    }

}