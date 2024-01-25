package br.com.fiap.fase4streamingvideos.application.video.interactors;

import br.com.fiap.fase4streamingvideos.application.video.boundaries.input.register.IGetAllVideosBoundary;
import br.com.fiap.fase4streamingvideos.application.video.boundaries.output.register.IGetAllVideosGateway;
import br.com.fiap.fase4streamingvideos.application.video.exception.VideoCustomException;
import br.com.fiap.fase4streamingvideos.application.video.model.response.VideoResponseModel;
import br.com.fiap.fase4streamingvideos.application.video.presenter.IVideoPresenter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;

public class GetAllVideosInteractor implements IGetAllVideosBoundary {
    IVideoPresenter presenter;
    IGetAllVideosGateway gateway;

    public GetAllVideosInteractor(IVideoPresenter presenter, IGetAllVideosGateway gateway) {
        this.presenter = presenter;
        this.gateway = gateway;
    }

    @Override
    public Flux<Page<VideoResponseModel>> findAll(Pageable pageable) throws VideoCustomException {
        Flux<Page<VideoResponseModel>> model = gateway.findAll(pageable);

        return model.flatMap(modelMap -> {
            if (modelMap.getContent().isEmpty()) {
                return presenter.prepareFailViewList(new VideoCustomException("Videos not found"));
            } else {
                return presenter.prepareSuccessViewList(Flux.just(modelMap));
            }
        });
    }
}
