package br.com.fiap.fase4streamingvideos.application.user.interectors;

import br.com.fiap.fase4streamingvideos.application.user.boundaries.input.ICreateUserBoundary;
import br.com.fiap.fase4streamingvideos.application.user.boundaries.output.IUserRegisterGateway;
import br.com.fiap.fase4streamingvideos.application.user.exception.UserCustomException;
import br.com.fiap.fase4streamingvideos.application.user.model.request.UserRequestModel;
import br.com.fiap.fase4streamingvideos.application.user.model.response.UserResponseModel;
import br.com.fiap.fase4streamingvideos.application.user.presenter.IUserPresenter;
import br.com.fiap.fase4streamingvideos.domain.IUser;
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

    @Override
    public Mono<UserResponseModel> create(UserRequestModel requestModel) throws UserCustomException {
        return gateway.existsByEmail(requestModel.getEmail())
                .flatMap(emailExists -> {
                    if (emailExists) {
                        return presenter.prepareFailView(new UserCustomException("Email: " + requestModel.getEmail() + " already in database"));
                    }

                    IUser user = factory.create(requestModel.getName(), requestModel.getEmail());

                    Mono<UserResponseModel> save = gateway.save(user);

                    return presenter.prepareSuccessView(save);
                });
    }
}
