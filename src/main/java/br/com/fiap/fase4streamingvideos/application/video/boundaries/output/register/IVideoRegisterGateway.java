package br.com.fiap.fase4streamingvideos.application.video.boundaries.output.register;

import br.com.fiap.fase4streamingvideos.domain.IVideo;

public interface IVideoRegisterGateway extends IVideoExistsGateway {
    void save(IVideo iVideo);
}
