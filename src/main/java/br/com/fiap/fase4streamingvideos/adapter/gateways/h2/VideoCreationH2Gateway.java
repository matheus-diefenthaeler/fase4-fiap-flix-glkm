package br.com.fiap.fase4streamingvideos.adapter.gateways.h2;

import br.com.fiap.fase4streamingvideos.adapter.gateways.mapper.VideoJpaMapper;
import br.com.fiap.fase4streamingvideos.adapter.repository.IVideoRepository;
import br.com.fiap.fase4streamingvideos.application.video.boundaries.output.register.IVideoRegisterGateway;
import br.com.fiap.fase4streamingvideos.domain.IVideo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VideoCreationH2Gateway implements IVideoRegisterGateway {

    @Autowired
    IVideoRepository _repository;

    public VideoCreationH2Gateway() {
    }

    @Override
    public boolean existsById(Long id) {
        return this._repository.existsById(id);
    }

    @Override
    public void save(IVideo iVideo) {
        VideoJpaMapper videoJpaMapper = new VideoJpaMapper(iVideo.getId(), iVideo.getTitle(),
                iVideo.getDescription(), iVideo.getUrl(), iVideo.getCreatedAt(), iVideo.getCategory());

        this._repository.save(videoJpaMapper);
    }
}
