package br.com.fiap.fase4streamingvideos.application.video.interactors;

import br.com.fiap.fase4streamingvideos.application.video.boundaries.input.register.IReadVideoBoundary;
import br.com.fiap.fase4streamingvideos.application.video.boundaries.input.register.IUpdateVideoBoundary;
import br.com.fiap.fase4streamingvideos.application.video.boundaries.output.register.IGetVideoGateway;
import br.com.fiap.fase4streamingvideos.application.video.boundaries.output.register.IUpdateVideoGateway;
import br.com.fiap.fase4streamingvideos.application.video.exception.VideoCustomException;
import br.com.fiap.fase4streamingvideos.application.video.model.request.VideoRequestModel;
import br.com.fiap.fase4streamingvideos.application.video.model.response.VideoResponseModel;
import br.com.fiap.fase4streamingvideos.application.video.presenter.IVideoPresenter;
import reactor.core.publisher.Mono;

public class UpdateVideoInteractor implements IUpdateVideoBoundary {
    IVideoPresenter presenter;
    IUpdateVideoGateway gateway;
    IReadVideoBoundary getVideoBoundary;

    public UpdateVideoInteractor(IVideoPresenter presenter, IUpdateVideoGateway gateway, IReadVideoBoundary getVideoBoundary) {
        this.presenter = presenter;
        this.gateway = gateway;
        this.getVideoBoundary = getVideoBoundary;
    }

    @Override
    public Mono<VideoResponseModel> updateById(String id, VideoRequestModel videoRequestModel) {
        return getVideoBoundary.findById(id)
                .switchIfEmpty(Mono.error(new VideoCustomException("Video not found with id: " + id)))
                .flatMap(existingVideo -> {

                    if (videoRequestModel.getTitle() == null || videoRequestModel.getDescription() == null ||
                            videoRequestModel.getUrl() == null || videoRequestModel.getCategory() == null) {
                        return presenter.prepareFailView(new VideoCustomException("All fields (title, description, url, category) are mandatory"));
                    }

                    return gateway.updateById(id, videoRequestModel);
                })
                .flatMap(videoUpdated -> presenter.prepareSuccessView(Mono.just(videoUpdated)));
    }
}
