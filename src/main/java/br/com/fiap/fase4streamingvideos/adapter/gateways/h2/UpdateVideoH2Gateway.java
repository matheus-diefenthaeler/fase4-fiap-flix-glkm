package br.com.fiap.fase4streamingvideos.adapter.gateways.h2;

import br.com.fiap.fase4streamingvideos.adapter.gateways.mapper.VideoJpaMapper;
import br.com.fiap.fase4streamingvideos.adapter.gateways.mapper.VideoMapper;
import br.com.fiap.fase4streamingvideos.adapter.repository.IVideoRepository;
import br.com.fiap.fase4streamingvideos.application.video.boundaries.output.register.IUpdateVideoGateway;
import br.com.fiap.fase4streamingvideos.application.video.model.request.VideoRequestModel;
import br.com.fiap.fase4streamingvideos.application.video.model.response.VideoResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateVideoH2Gateway implements IUpdateVideoGateway {
    @Autowired
    IVideoRepository _repository;

    public UpdateVideoH2Gateway() {}

    @Override
    public VideoResponseModel updateById(Long id, VideoRequestModel videoRequestModel) {
        VideoJpaMapper videoToUpdate = _repository.findById(id).get();
        VideoJpaMapper videoUpdated = new VideoJpaMapper(id, videoRequestModel.getTitle(), videoRequestModel.getDescription(), videoRequestModel.getUrl(), videoToUpdate.getCreatedAt(), videoRequestModel.getCategory());

        _repository.save(videoUpdated);

        return VideoMapper.toRespondeModel(videoUpdated);
    }
}
