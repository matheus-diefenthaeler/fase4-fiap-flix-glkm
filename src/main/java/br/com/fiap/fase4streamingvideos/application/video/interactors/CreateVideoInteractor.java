package br.com.fiap.fase4streamingvideos.application.video.interactors;

import br.com.fiap.fase4streamingvideos.application.video.boundaries.input.register.ICreateVideoBoundary;
import br.com.fiap.fase4streamingvideos.application.video.boundaries.output.register.IVideoRegisterGateway;
import br.com.fiap.fase4streamingvideos.application.video.exception.VideoCustomException;
import br.com.fiap.fase4streamingvideos.application.video.model.request.VideoRequestModel;
import br.com.fiap.fase4streamingvideos.application.video.model.response.VideoResponseModel;
import br.com.fiap.fase4streamingvideos.application.video.presenter.IVideoPresenter;
import br.com.fiap.fase4streamingvideos.domain.IVideo;
import br.com.fiap.fase4streamingvideos.domain.factories.IVideoFactory;

public class CreateVideoInteractor implements ICreateVideoBoundary {

    IVideoPresenter presenter;
    IVideoFactory factory;
    IVideoRegisterGateway gateway;

    public CreateVideoInteractor(IVideoPresenter presenter, IVideoFactory factory, IVideoRegisterGateway gateway) {
        this.presenter = presenter;
        this.factory = factory;
        this.gateway = gateway;
    }

    @Override
    public VideoResponseModel create(VideoRequestModel requestModel) throws VideoCustomException {
        if (gateway.existsByTitle(requestModel.getTitle())) {
            return presenter.prepareFailView(new VideoCustomException("Video with title: " + requestModel.getTitle() + " already in database"));
        }

        IVideo video = factory.create(requestModel.getTitle(), requestModel.getDescription(), requestModel.getUrl(), requestModel.getCategory());

        VideoResponseModel save = gateway.save(video);

        return presenter.prepareSuccessView(save);
    }
}
