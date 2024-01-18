package br.com.fiap.fase4streamingvideos.application.video.interactors;

import br.com.fiap.fase4streamingvideos.application.video.boundaries.input.register.IUpdateVideoBoundary;
import br.com.fiap.fase4streamingvideos.application.video.boundaries.output.register.IGetVideoGateway;
import br.com.fiap.fase4streamingvideos.application.video.boundaries.output.register.IUpdateVideoGateway;
import br.com.fiap.fase4streamingvideos.application.video.exception.VideoCustomException;
import br.com.fiap.fase4streamingvideos.application.video.model.request.VideoRequestModel;
import br.com.fiap.fase4streamingvideos.application.video.model.response.VideoResponseModel;
import br.com.fiap.fase4streamingvideos.application.video.presenter.IVideoPresenter;

public class UpdateVideoInteractor implements IUpdateVideoBoundary {
    IVideoPresenter presenter;
    IUpdateVideoGateway gateway;
    IGetVideoGateway getVideoGateway;

    public UpdateVideoInteractor(IVideoPresenter presenter, IUpdateVideoGateway gateway, IGetVideoGateway getVideoGateway) {
        this.presenter = presenter;
        this.gateway = gateway;
        this.getVideoGateway = getVideoGateway;
    }

    @Override
    public VideoResponseModel updateById(Long id, VideoRequestModel videoRequestModel) {
        getVideoGateway.findById(id);

        if(videoRequestModel.getTitle() == null) return presenter.prepareFailView(new VideoCustomException("title field is mandatory"));
        if(videoRequestModel.getDescription() == null) return presenter.prepareFailView(new VideoCustomException("description field is mandatory"));
        if(videoRequestModel.getUrl() == null) return presenter.prepareFailView(new VideoCustomException("url field is mandatory"));
        if(videoRequestModel.getCategory() == null) return presenter.prepareFailView(new VideoCustomException("category field is mandatory"));

        VideoResponseModel videoResponseModel = gateway.updateById(id, videoRequestModel);

        return presenter.prepareSuccessView(videoResponseModel);
    }
}
