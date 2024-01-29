package br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.impl.video;

import br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.mapper.VideoMapper;
import br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.model.VideoMongoDB;
import br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.repository.IVideoMongoDbRepository;
import br.com.fiap.fase4streamingvideos.application.video.boundaries.output.register.IGetVideoGateway;
import br.com.fiap.fase4streamingvideos.application.video.exception.VideoCustomException;
import br.com.fiap.fase4streamingvideos.application.video.model.response.VideoResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

@Component
public class GetVideoMongoDbGateway implements IGetVideoGateway {

    @Autowired
    IVideoMongoDbRepository _repository;

    public GetVideoMongoDbGateway() {
    }

    @Override
    public Mono<Boolean> existsByTitle(String title) {
        return this._repository.existsByTitle(title);
    }

    @Override
    public Mono<VideoResponseModel> findById(String id) {
        Mono<VideoMongoDB> video = _repository.findById(id);
        return VideoMapper.toRespondeModel(video);
    }
}
