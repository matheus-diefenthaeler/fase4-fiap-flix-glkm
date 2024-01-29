package br.com.fiap.fase4streamingvideos.application.favorite.interactors;

import br.com.fiap.fase4streamingvideos.application.favorite.boundaries.input.ICreateFavoriteBoundary;
import br.com.fiap.fase4streamingvideos.application.favorite.boundaries.output.ICreateFavoriteGateway;
import br.com.fiap.fase4streamingvideos.application.favorite.exception.FavoriteCustomException;
import br.com.fiap.fase4streamingvideos.application.favorite.model.request.FavoriteRequestModel;
import br.com.fiap.fase4streamingvideos.application.favorite.model.response.FavoriteResponseModel;
import br.com.fiap.fase4streamingvideos.application.favorite.presenter.IFavoritePresenter;
import br.com.fiap.fase4streamingvideos.application.user.boundaries.input.IFindByIdUserBoundary;
import br.com.fiap.fase4streamingvideos.application.video.boundaries.input.register.IReadVideoBoundary;
import br.com.fiap.fase4streamingvideos.domain.IFavorite;
import br.com.fiap.fase4streamingvideos.domain.factories.IFavoriteFactory;
import reactor.core.publisher.Mono;

public class CreateFavoriteInteractor implements ICreateFavoriteBoundary {
    IFavoritePresenter presenter;
    IFavoriteFactory factory;
    ICreateFavoriteGateway gateway;
    IReadVideoBoundary readVideoBoundary;

    IFindByIdUserBoundary findByIdUserBoundary;

    public CreateFavoriteInteractor(IFavoritePresenter presenter, IFavoriteFactory factory, ICreateFavoriteGateway gateway, IReadVideoBoundary readVideoBoundary, IFindByIdUserBoundary findByIdUserBoundary) {
        this.presenter = presenter;
        this.factory = factory;
        this.gateway = gateway;
        this.readVideoBoundary = readVideoBoundary;
        this.findByIdUserBoundary = findByIdUserBoundary;
    }

    @Override
    public Mono<FavoriteResponseModel> create(FavoriteRequestModel requestModel) throws FavoriteCustomException {
        return gateway.existsByIdVideoAndIdUser(requestModel.getIdVideo(), requestModel.getIdUser())
                .flatMap(idVideoExists -> {
                    if (idVideoExists) {
                        return presenter.prepareFailView(new FavoriteCustomException("Video: " + requestModel.getIdVideo() + " already added"));
                    }

                    return findByIdUserBoundary.findById(requestModel.getIdUser()).flatMap(user -> {
                        return readVideoBoundary.findById(requestModel.getIdVideo())
                            .flatMap(video -> {
                                String nameVideo = video.getTitulo();

                                IFavorite favorite = factory.create(requestModel.getIdVideo(), requestModel.getIdUser(), nameVideo);

                                return gateway.save(favorite)
                                        .flatMap(savedFavorite -> presenter.prepareSuccessView(Mono.just(savedFavorite)))
                                        .switchIfEmpty(Mono.defer(() -> {
                                            return presenter.prepareFailView(new FavoriteCustomException("Video not found: " + requestModel.getIdVideo()));
                                        }));
                            })
                            .switchIfEmpty(Mono.defer(() -> {
                                return presenter.prepareFailView(new FavoriteCustomException("Video not found: " + requestModel.getIdVideo()));
                            }));
                    });
                });
    }
}
