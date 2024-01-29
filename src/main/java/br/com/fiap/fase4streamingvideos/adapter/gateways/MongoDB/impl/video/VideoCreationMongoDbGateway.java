package br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.impl.video;

import br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.mapper.VideoMapper;
import br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.model.VideoMongoDB;
import br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.repository.IVideoMongoDbRepository;
import br.com.fiap.fase4streamingvideos.application.video.boundaries.output.register.IVideoRegisterGateway;
import br.com.fiap.fase4streamingvideos.application.video.model.response.VideoResponseModel;
import br.com.fiap.fase4streamingvideos.domain.IVideo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class VideoCreationMongoDbGateway implements IVideoRegisterGateway {

    @Autowired
    IVideoMongoDbRepository repository;

    public VideoCreationMongoDbGateway() {}

    @Override
    public Mono<VideoResponseModel> save(IVideo iVideo) {
        VideoMongoDB video = new VideoMongoDB(iVideo.getTitle(), iVideo.getUrl(), iVideo.getCategory(), iVideo.getCreatedAt(), iVideo.getDescription(), iVideo.getViews());

        Mono<VideoMongoDB> saveMono = repository.save(video);


        return VideoMapper.toRespondeModel(saveMono);
    }

    @Override
    public Mono<Boolean> existsByTitle(String title) {
        return repository.existsByTitle(title);
    }
}
