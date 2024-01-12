package br.com.fiap.fase4streamingvideos.adapter.gateways.h2;

import br.com.fiap.fase4streamingvideos.adapter.gateways.mapper.VideoJpaMapper;
import br.com.fiap.fase4streamingvideos.adapter.repository.IVideoRepository;
import br.com.fiap.fase4streamingvideos.application.video.boundaries.output.register.IGetVideoGateway;
import br.com.fiap.fase4streamingvideos.application.video.boundaries.output.register.IVideoRegisterGateway;
import br.com.fiap.fase4streamingvideos.application.video.exception.VideoCustomException;
import br.com.fiap.fase4streamingvideos.application.video.model.response.VideoResponseModel;
import br.com.fiap.fase4streamingvideos.domain.IVideo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetVideoH2Gateway implements IGetVideoGateway {

    @Autowired
    IVideoRepository repository;

    public GetVideoH2Gateway() {
    }

    @Override
    public boolean existsByTitle(String title) {
        return this.repository.existsByTitle(title);
    }

    @Override
    public VideoResponseModel findById(Long id) {
        VideoJpaMapper video = repository.findById(id).orElseThrow(() -> new VideoCustomException("Video not found!"));;
        VideoResponseModel model = new VideoResponseModel(video.getTitle(),
                video.getDescription(), video.getUrl(), String.valueOf(video.getCreatedAt()));
        return model;
    }
}
