package br.com.fiap.fase4streamingvideos.application.user.boundaries.output;

import reactor.core.publisher.Mono;

public interface IUserExistsGateway {
    Mono<Boolean> existsByEmail(String email);
}
