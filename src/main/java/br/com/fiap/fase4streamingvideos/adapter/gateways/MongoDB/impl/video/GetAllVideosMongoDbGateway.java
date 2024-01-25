package br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.impl.video;

import br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.mapper.VideoMapper;
import br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.model.VideoMongoDB;
import br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.repository.IVideoMongoDbRepository;
import br.com.fiap.fase4streamingvideos.application.video.boundaries.output.register.IGetAllVideosGateway;
import br.com.fiap.fase4streamingvideos.application.video.model.response.VideoResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class GetAllVideosMongoDbGateway implements IGetAllVideosGateway {
    @Autowired
    IVideoMongoDbRepository _repository;

    public GetAllVideosMongoDbGateway() {}

    @Override
    public Flux<Page<VideoResponseModel>> findAll(Pageable pageable) {
        Flux<VideoMongoDB> videos = _repository.findAll(pageable);

        return VideoMapper.listMongoToListResponseModel(videos);
    }
}
