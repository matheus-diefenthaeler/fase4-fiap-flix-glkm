package br.com.fiap.fase4streamingvideos.application.video.boundaries.output.register;

import reactor.core.publisher.Mono;

public interface IDeleteVideoGateway {
    Mono<Void> deleteById(String id);
}
