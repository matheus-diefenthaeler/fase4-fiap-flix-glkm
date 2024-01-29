package br.com.fiap.fase4streamingvideos.application.user.interectors;

import br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.dto.request.WatchVideoRequest;
import br.com.fiap.fase4streamingvideos.application.user.boundaries.input.IUserWatchVideoBoundary;
import br.com.fiap.fase4streamingvideos.application.user.boundaries.output.IUserExistsGateway;
import br.com.fiap.fase4streamingvideos.application.user.boundaries.output.IWatchVideoUserGateway;
import br.com.fiap.fase4streamingvideos.application.user.exception.UserCustomException;
import br.com.fiap.fase4streamingvideos.application.user.presenter.IUserPresenter;
import br.com.fiap.fase4streamingvideos.application.video.boundaries.output.register.IVideoExistsGateway;
import br.com.fiap.fase4streamingvideos.application.video.exception.VideoCustomException;
import br.com.fiap.fase4streamingvideos.domain.factories.IUserFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class WatchVideoUserInteractor implements IUserWatchVideoBoundary {

    IUserPresenter presenter;
    IUserFactory factory;
    IWatchVideoUserGateway gateway;
    IUserExistsGateway userGateway;
    IVideoExistsGateway videoGateway;

    public WatchVideoUserInteractor(IUserPresenter presenter, IUserFactory factory, IWatchVideoUserGateway gateway, @Qualifier("userCreationMongoDbGateway") IUserExistsGateway userGateway, @Qualifier("videoCreationMongoDbGateway") IVideoExistsGateway videoGateway) {
        this.presenter = presenter;
        this.factory = factory;
        this.gateway = gateway;
        this.userGateway = userGateway;
        this.videoGateway = videoGateway;
    }

    @Override
    public Mono<ResponseEntity<Void>> toWatch(WatchVideoRequest request, String videoId) {
        return userGateway.existsByEmail(request.getUserEmail())
                .flatMap(userExists -> {
                    if (!userExists) {
                        return Mono.error(new UserCustomException("User not found"));
                    }
                    return videoGateway.existsByTitle(request.getVideoTitle())
                            .flatMap(videoExists -> {
                                if (!videoExists) {
                                    return Mono.error(new VideoCustomException("Video not found"));
                                }
                                return gateway.incrementViews(videoId)
                                        .flatMap(incremented -> {
                                            if (incremented) {
                                                return Mono.just(ResponseEntity.noContent().build());
                                            } else {
                                                return Mono.error(new VideoCustomException("ID: " + videoId + " not found!"));
                                            }
                                        });
                            });
                })
                .onErrorResume(UserCustomException.class, e -> presenter.prepareFailView(e)
                        .map(responseModel -> ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseModel)))
                .map(responseEntity -> ResponseEntity.noContent().build());
    }
}




