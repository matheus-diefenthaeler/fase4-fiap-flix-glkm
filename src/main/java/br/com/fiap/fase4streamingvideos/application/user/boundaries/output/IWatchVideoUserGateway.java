package br.com.fiap.fase4streamingvideos.application.user.boundaries.output;

import reactor.core.publisher.Mono;

public interface IWatchVideoUserGateway {

    Mono<Boolean> incrementViews(String id);

}
