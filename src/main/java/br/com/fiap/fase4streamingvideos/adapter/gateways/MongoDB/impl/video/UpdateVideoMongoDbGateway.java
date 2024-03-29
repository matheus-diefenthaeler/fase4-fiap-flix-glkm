package br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.impl.video;

import br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.mapper.VideoMapper;
import br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.model.VideoMongoDB;
import br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.repository.IVideoMongoDbRepository;
import br.com.fiap.fase4streamingvideos.application.video.boundaries.output.register.IUpdateVideoGateway;
import br.com.fiap.fase4streamingvideos.application.video.exception.VideoCustomException;
import br.com.fiap.fase4streamingvideos.application.video.model.request.VideoRequestModel;
import br.com.fiap.fase4streamingvideos.application.video.model.response.VideoResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class UpdateVideoMongoDbGateway implements IUpdateVideoGateway {
    @Autowired
    IVideoMongoDbRepository _repository;

    public UpdateVideoMongoDbGateway() {}

    @Override
    public Mono<VideoResponseModel> updateById(String id, VideoRequestModel videoRequestModel) {
        return _repository.findById(id)
                .flatMap(existingVideo -> {
                    existingVideo.setTitle(videoRequestModel.getTitle());
                    existingVideo.setDescription(videoRequestModel.getDescription());
                    existingVideo.setUrl(videoRequestModel.getUrl());
                    existingVideo.setCategory(videoRequestModel.getCategory());

                    Mono<VideoMongoDB> saveMono = _repository.save(existingVideo);

                    return VideoMapper.toRespondeModel(saveMono);
                });
    }
}
