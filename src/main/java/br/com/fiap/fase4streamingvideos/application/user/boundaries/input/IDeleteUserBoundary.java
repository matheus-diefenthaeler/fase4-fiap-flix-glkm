package br.com.fiap.fase4streamingvideos.application.user.boundaries.input;

import br.com.fiap.fase4streamingvideos.application.user.exception.UserCustomException;
import reactor.core.publisher.Mono;

public interface IDeleteUserBoundary {

    Mono<Void> deleteByEmail(String email) throws UserCustomException;
}
