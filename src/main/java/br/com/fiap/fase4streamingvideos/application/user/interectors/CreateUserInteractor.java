package br.com.fiap.fase4streamingvideos.application.user.interectors;

import br.com.fiap.fase4streamingvideos.application.user.boundaries.input.ICreateUserBoundary;
import br.com.fiap.fase4streamingvideos.application.user.boundaries.output.IUserRegisterGateway;
import br.com.fiap.fase4streamingvideos.application.user.exception.UserCustomException;
import br.com.fiap.fase4streamingvideos.application.user.model.request.UserRequestModel;
import br.com.fiap.fase4streamingvideos.application.user.model.response.UserResponseModel;
import br.com.fiap.fase4streamingvideos.application.user.presenter.IUserPresenter;
import br.com.fiap.fase4streamingvideos.application.video.exception.VideoCustomException;
import br.com.fiap.fase4streamingvideos.application.video.model.request.VideoRequestModel;
import br.com.fiap.fase4streamingvideos.application.video.model.response.VideoResponseModel;
import br.com.fiap.fase4streamingvideos.domain.IUser;
import br.com.fiap.fase4streamingvideos.domain.IVideo;
import br.com.fiap.fase4streamingvideos.domain.factories.IUserFactory;
import reactor.core.publisher.Mono;

public class CreateUserInteractor implements ICreateUserBoundary {

    IUserPresenter presenter;
    IUserFactory factory;
    IUserRegisterGateway gateway;

    public CreateUserInteractor(IUserPresenter presenter, IUserFactory factory, IUserRegisterGateway gateway) {
        this.presenter = presenter;
        this.factory = factory;
        this.gateway = gateway;
    }

//    @Override
//    public Mono<UserResponseModel> create(UserRequestModel requestModel) {
//        return gateway.existsByEmail(requestModel.getEmail())
//                .flatMap(exists -> {
//                    if (exists) {
//                        return Mono.error(new UserCustomException("Email: " + requestModel.getEmail() + " already in database"));
//                    } else {
//                        IUser user = factory.create(requestModel.getName(), requestModel.getEmail());
//                        return gateway.save(user)
//                                .map(presenter::prepareSuccessView);
//                    }
//                })
//                .onErrorResume(throwable -> Mono.just(presenter.prepareFailView(throwable)));
//    }

//    @Override
//    public Mono<UserResponseModel> create(UserRequestModel requestModel) {
//        return gateway.existsByEmail(requestModel.getEmail())
//                .flatMap(exists -> exists
//                        ? Mono.error(new UserCustomException("Email: " + requestModel.getEmail() + " already in database"))
//                        : gateway.save(factory.create(requestModel.getName(), requestModel.getEmail()))
//                        .map(presenter::prepareSuccessView))
//                .switchIfEmpty(Mono.error(new UserCustomException("Unexpected error")));
//    }

    @Override
    public UserResponseModel create(UserRequestModel requestModel) throws VideoCustomException {
//        if (gateway.existsByEmail(requestModel.getEmail())) {
//            return presenter.prepareFailView(new UserCustomException("Email: " + requestModel.getEmail() + " already in database"));
//        }

        IUser user = factory.create(requestModel.getName(), requestModel.getEmail());

        UserResponseModel save = gateway.save(user);

        return presenter.prepareSuccessView(save);
    }
}
