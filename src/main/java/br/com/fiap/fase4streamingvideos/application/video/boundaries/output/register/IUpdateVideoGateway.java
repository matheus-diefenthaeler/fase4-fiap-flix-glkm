package br.com.fiap.fase4streamingvideos.application.video.boundaries.output.register;

import br.com.fiap.fase4streamingvideos.application.video.model.request.VideoRequestModel;
import br.com.fiap.fase4streamingvideos.application.video.model.response.VideoResponseModel;

public interface IUpdateVideoGateway {
    VideoResponseModel updateById(Long id, VideoRequestModel videoRequestModel);
}
