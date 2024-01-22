package br.com.fiap.fase4streamingvideos.application.video.boundaries.output.register;

import br.com.fiap.fase4streamingvideos.application.video.model.response.VideoResponseModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IGetAllVideosGateway {
    Page<VideoResponseModel> findAll(Pageable pageable);
}
