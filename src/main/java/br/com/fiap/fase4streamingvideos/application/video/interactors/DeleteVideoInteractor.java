package br.com.fiap.fase4streamingvideos.application.video.interactors;

import br.com.fiap.fase4streamingvideos.application.video.boundaries.input.register.IDeleteVideoBoundary;
import br.com.fiap.fase4streamingvideos.application.video.boundaries.input.register.IReadVideoBoundary;
import br.com.fiap.fase4streamingvideos.application.video.boundaries.output.register.IDeleteVideoGateway;
import br.com.fiap.fase4streamingvideos.application.video.boundaries.output.register.IGetVideoGateway;
import br.com.fiap.fase4streamingvideos.application.video.boundaries.output.register.IVideoRegisterGateway;
import br.com.fiap.fase4streamingvideos.application.video.exception.VideoCustomException;
import br.com.fiap.fase4streamingvideos.application.video.model.request.VideoRequestModel;
import br.com.fiap.fase4streamingvideos.application.video.model.response.VideoResponseModel;
import br.com.fiap.fase4streamingvideos.application.video.presenter.IVideoPresenter;
import br.com.fiap.fase4streamingvideos.domain.IVideo;
import br.com.fiap.fase4streamingvideos.domain.factories.IVideoFactory;

public class DeleteVideoInteractor implements IDeleteVideoBoundary {
    IVideoPresenter presenter;
    IDeleteVideoGateway gateway;

    IGetVideoGateway getVideoGateway;

    public DeleteVideoInteractor(IVideoPresenter presenter, IDeleteVideoGateway gateway, IGetVideoGateway getVideoGateway) {
        this.presenter = presenter;
        this.gateway = gateway;
        this.getVideoGateway = getVideoGateway;
    }

    @Override
    public void deleteById(Long id) {
        getVideoGateway.findById(id);
        gateway.deleteById(id);

        presenter.prepareSuccessViewStatus("Deleted Successfully");
    }
}
