package br.com.fiap.fase4streamingvideos.application.video.boundaries.output.register;

import br.com.fiap.fase4streamingvideos.application.video.model.response.VideoResponseModel;
import reactor.core.publisher.Mono;

import java.util.Optional;

public interface IGetVideoGateway extends IVideoExistsGateway{
    Mono<VideoResponseModel> findById(String id);
}
