package br.com.fiap.fase4streamingvideos.application.video.boundaries.output.register;

import br.com.fiap.fase4streamingvideos.application.video.model.response.VideoResponseModel;
import br.com.fiap.fase4streamingvideos.domain.IVideo;

public interface IVideoRegisterGateway extends IVideoExistsGateway {
    VideoResponseModel save(IVideo iVideo);
}
