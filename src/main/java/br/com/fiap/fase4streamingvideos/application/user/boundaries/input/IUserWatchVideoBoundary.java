package br.com.fiap.fase4streamingvideos.application.user.boundaries.input;

import br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.dto.request.WatchVideoRequest;
import reactor.core.publisher.Mono;

public interface IUserWatchVideoBoundary {

    Mono<?> toWatch(WatchVideoRequest request, String videoId);
}
