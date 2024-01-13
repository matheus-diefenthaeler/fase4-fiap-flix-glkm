package br.com.fiap.fase4streamingvideos.adapter.gateways.h2;

import br.com.fiap.fase4streamingvideos.adapter.gateways.mapper.VideoJpaMapper;
import br.com.fiap.fase4streamingvideos.adapter.gateways.mapper.VideoMapper;
import br.com.fiap.fase4streamingvideos.adapter.repository.IVideoRepository;
import br.com.fiap.fase4streamingvideos.application.video.boundaries.output.register.IVideoRegisterGateway;
import br.com.fiap.fase4streamingvideos.application.video.model.response.VideoResponseModel;
import br.com.fiap.fase4streamingvideos.domain.IVideo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VideoCreationH2Gateway implements IVideoRegisterGateway {

    @Autowired
    IVideoRepository repository;

    public VideoCreationH2Gateway() {
    }


    @Override
    public VideoResponseModel save(IVideo iVideo) {
        VideoJpaMapper videoJpaMapper = new VideoJpaMapper(iVideo.getTitle(),
                iVideo.getDescription(), iVideo.getUrl(), iVideo.getCreatedAt(), iVideo.getCategory());

        repository.save(videoJpaMapper);

        return VideoMapper.toRespondeModel(videoJpaMapper);
    }

    @Override
    public boolean existsByTitle(String title) {
        return this.repository.existsByTitle(title);
    }
}
