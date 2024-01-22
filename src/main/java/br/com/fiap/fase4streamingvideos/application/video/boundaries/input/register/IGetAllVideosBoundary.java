package br.com.fiap.fase4streamingvideos.application.video.boundaries.input.register;

import br.com.fiap.fase4streamingvideos.application.video.model.response.VideoResponseModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IGetAllVideosBoundary {
    Page<VideoResponseModel> findAll(Pageable pageable);
}
