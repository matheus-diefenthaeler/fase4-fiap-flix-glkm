package br.com.fiap.fase4streamingvideos.application.video.interactors;

import br.com.fiap.fase4streamingvideos.application.video.boundaries.input.register.IReadVideoBoundary;
import br.com.fiap.fase4streamingvideos.application.video.boundaries.output.register.IGetVideoGateway;
import br.com.fiap.fase4streamingvideos.application.video.exception.VideoCustomException;
import br.com.fiap.fase4streamingvideos.application.video.model.response.VideoResponseModel;
import br.com.fiap.fase4streamingvideos.application.video.presenter.IVideoPresenter;
import br.com.fiap.fase4streamingvideos.domain.factories.IVideoFactory;
import reactor.core.publisher.Mono;

public class ReadVideoInteractor implements IReadVideoBoundary {

    IVideoPresenter presenter;
    IVideoFactory factory;
    IGetVideoGateway gateway;

    public ReadVideoInteractor(IVideoPresenter presenter, IVideoFactory factory, IGetVideoGateway gateway) {
        this.presenter = presenter;
        this.factory = factory;
        this.gateway = gateway;
    }

    @Override
    public Mono<VideoResponseModel> findById(String id) throws VideoCustomException {
        return gateway.findById(id)
                .switchIfEmpty(Mono.error(new VideoCustomException("Video not found with id: " + id)))
                .flatMap(video -> presenter.prepareSuccessView(Mono.just(video)));
    }
}

