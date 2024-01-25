package br.com.fiap.fase4streamingvideos.application.video.boundaries.output.register;

import br.com.fiap.fase4streamingvideos.application.video.model.response.VideoResponseModel;
import br.com.fiap.fase4streamingvideos.domain.IVideo;
import reactor.core.publisher.Mono;

public interface IVideoRegisterGateway extends IVideoExistsGateway {
    Mono<VideoResponseModel> save(IVideo iVideo);
}
