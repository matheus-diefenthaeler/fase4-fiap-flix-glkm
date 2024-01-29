package br.com.fiap.fase4streamingvideos.application.video.interactors;

import br.com.fiap.fase4streamingvideos.application.video.boundaries.input.register.IGetAllVideosBoundary;
import br.com.fiap.fase4streamingvideos.application.video.boundaries.output.register.IGetAllVideosGateway;
import br.com.fiap.fase4streamingvideos.application.video.exception.VideoCustomException;
import br.com.fiap.fase4streamingvideos.application.video.model.response.VideoResponseModel;
import br.com.fiap.fase4streamingvideos.application.video.presenter.IVideoPresenter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
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
        return gateway.findAll(pageable)
                .collectList()
                .flatMapMany(videoList -> {
                    if (videoList.isEmpty()) {
                        return presenter.prepareFailViewList(new VideoCustomException("Videos not found"));
                    } else {
                        Page<VideoResponseModel> page = new PageImpl<>(videoList, pageable, videoList.size());
                        return presenter.prepareSuccessViewList(Flux.just(page));
                    }
                });
    }
}
