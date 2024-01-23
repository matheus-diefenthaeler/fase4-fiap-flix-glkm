package br.com.fiap.fase4streamingvideos.adapter.beanconfigs;

import br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.impl.UserCreationMongoDbGateway;
import br.com.fiap.fase4streamingvideos.adapter.presenter.UserPresenter;
import br.com.fiap.fase4streamingvideos.application.user.boundaries.input.ICreateUserBoundary;
import br.com.fiap.fase4streamingvideos.application.user.boundaries.input.IDeleteUserBoundary;
import br.com.fiap.fase4streamingvideos.application.user.boundaries.input.IFindAllUserBoundary;
import br.com.fiap.fase4streamingvideos.application.user.boundaries.input.IFindByIdUserBoundary;
import br.com.fiap.fase4streamingvideos.application.user.boundaries.output.IUserDeleteGateway;
import br.com.fiap.fase4streamingvideos.application.user.boundaries.output.IUserFindByIdGateway;
import br.com.fiap.fase4streamingvideos.application.user.boundaries.output.IUserFindGateway;
import br.com.fiap.fase4streamingvideos.application.user.boundaries.output.IUserRegisterGateway;
import br.com.fiap.fase4streamingvideos.application.user.interectors.CreateUserInteractor;
import br.com.fiap.fase4streamingvideos.application.user.interectors.DeleteUserInteractor;
import br.com.fiap.fase4streamingvideos.application.user.interectors.FindAllUserInteractor;
import br.com.fiap.fase4streamingvideos.application.user.interectors.FindByIdUserInteractor;
import br.com.fiap.fase4streamingvideos.application.user.presenter.IUserPresenter;
import br.com.fiap.fase4streamingvideos.domain.factories.IUserFactory;
import br.com.fiap.fase4streamingvideos.domain.factories.UserFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {

    @Bean
    public IUserFactory userFactory() {
        return new UserFactory();
    }

    @Bean
    public IUserPresenter userPresenter() {
        return new UserPresenter();
    }

    @Bean
    public IUserRegisterGateway userRegisterGateway() {
        return new UserCreationMongoDbGateway();
    }

    @Bean
    public ICreateUserBoundary userInputBoundary(IUserPresenter userPresenter, IUserFactory userFactory, IUserRegisterGateway userRegisterGateway) {
        return new CreateUserInteractor(userPresenter, userFactory, userRegisterGateway);
    }

    @Bean
    public IDeleteUserBoundary userDeleteInputBoundary(IUserPresenter userPresenter, IUserFactory userFactory, IUserDeleteGateway userDeleteGateway) {
        return new DeleteUserInteractor(userPresenter, userFactory, userDeleteGateway);
    }

    @Bean
    public IFindAllUserBoundary userFindAllInputBoundary(IUserPresenter userPresenter, IUserFactory userFactory, IUserFindGateway userFindGateway) {
        return new FindAllUserInteractor(userPresenter, userFactory, userFindGateway);
    }

    @Bean
    public IFindByIdUserBoundary userFindByIdInputBoundary(IUserPresenter userPresenter, IUserFactory userFactory, IUserFindByIdGateway userFindByIdGateway) {
        return new FindByIdUserInteractor(userPresenter, userFactory, userFindByIdGateway);
    }

}
