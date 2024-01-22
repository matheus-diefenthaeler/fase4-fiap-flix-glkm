package br.com.fiap.fase4streamingvideos.application.video.boundaries.input.register;

import br.com.fiap.fase4streamingvideos.application.video.model.request.VideoRequestModel;
import br.com.fiap.fase4streamingvideos.application.video.model.response.VideoResponseModel;

public interface IUpdateVideoBoundary {
    VideoResponseModel updateById(Long id, VideoRequestModel videoRequestModel);
}
