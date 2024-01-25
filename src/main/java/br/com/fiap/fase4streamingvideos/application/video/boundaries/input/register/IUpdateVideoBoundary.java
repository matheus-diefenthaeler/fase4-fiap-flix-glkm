package br.com.fiap.fase4streamingvideos.application.video.boundaries.input.register;

import br.com.fiap.fase4streamingvideos.application.video.model.request.VideoRequestModel;
import br.com.fiap.fase4streamingvideos.application.video.model.response.VideoResponseModel;
import reactor.core.publisher.Mono;

public interface IUpdateVideoBoundary {
    Mono<VideoResponseModel> updateById(String id, VideoRequestModel videoRequestModel);
}
