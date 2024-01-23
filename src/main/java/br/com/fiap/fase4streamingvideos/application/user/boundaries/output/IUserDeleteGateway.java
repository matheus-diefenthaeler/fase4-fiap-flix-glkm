package br.com.fiap.fase4streamingvideos.application.user.boundaries.output;

import reactor.core.publisher.Mono;

public interface IUserDeleteGateway extends IUserExistsGateway {

    Mono<Void> deleteByEmail(String id);

}
