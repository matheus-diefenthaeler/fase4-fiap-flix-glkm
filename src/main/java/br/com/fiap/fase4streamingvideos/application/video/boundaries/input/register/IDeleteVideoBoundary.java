package br.com.fiap.fase4streamingvideos.application.video.boundaries.input.register;

import reactor.core.publisher.Mono;

public interface IDeleteVideoBoundary {
    Mono<Void> deleteById(String id);
}
