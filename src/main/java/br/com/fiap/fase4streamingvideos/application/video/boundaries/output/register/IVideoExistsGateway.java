package br.com.fiap.fase4streamingvideos.application.video.boundaries.output.register;

import reactor.core.publisher.Mono;

public interface IVideoExistsGateway {
    Mono<Boolean> existsByTitle(String title);
}
