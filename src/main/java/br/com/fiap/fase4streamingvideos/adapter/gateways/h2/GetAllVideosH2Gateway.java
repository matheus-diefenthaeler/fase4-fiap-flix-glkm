package br.com.fiap.fase4streamingvideos.adapter.gateways.h2;

import br.com.fiap.fase4streamingvideos.adapter.gateways.mapper.VideoJpaMapper;
import br.com.fiap.fase4streamingvideos.adapter.gateways.mapper.VideoMapper;
import br.com.fiap.fase4streamingvideos.adapter.repository.IVideoRepository;
import br.com.fiap.fase4streamingvideos.application.video.boundaries.output.register.IGetAllVideosGateway;
import br.com.fiap.fase4streamingvideos.application.video.model.response.VideoResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class GetAllVideosH2Gateway implements IGetAllVideosGateway {

    @Autowired
    IVideoRepository _repository;

    public GetAllVideosH2Gateway() {}

    @Override
    public Page<VideoResponseModel> findAll(Pageable pageable) {
        Page<VideoJpaMapper> videos = _repository.findAll(pageable);
        return VideoMapper.listJPAtoListResponseModel(videos);
    }
}
