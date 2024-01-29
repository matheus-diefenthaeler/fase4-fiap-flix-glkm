package br.com.fiap.fase4streamingvideos.adapter.beanconfigs;

import br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.impl.user.UserCreationMongoDbGateway;
import br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.impl.video.VideoCreationMongoDbGateway;
import br.com.fiap.fase4streamingvideos.adapter.presenter.UserPresenter;
import br.com.fiap.fase4streamingvideos.application.user.boundaries.input.*;
import br.com.fiap.fase4streamingvideos.application.user.boundaries.output.*;
import br.com.fiap.fase4streamingvideos.application.user.interectors.*;
import br.com.fiap.fase4streamingvideos.application.user.presenter.IUserPresenter;
import br.com.fiap.fase4streamingvideos.application.video.boundaries.output.register.IVideoExistsGateway;
import br.com.fiap.fase4streamingvideos.domain.factories.IUserFactory;
import br.com.fiap.fase4streamingvideos.domain.factories.UserFactory;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @Bean
    public IGetUserFavoritesBoundary getUserFavoritesBoundary(IUserPresenter userPresenter, IUserFactory userFactory, IGetUserFavoritesGateway getUserFavoritesGateway) {
        return new GetUserFavoritesInteractor(userPresenter, userFactory, getUserFavoritesGateway);
    }

    @Bean
    public IUserWatchVideoBoundary watchVideoBoundary(IUserPresenter userPresenter,
                                                      IUserFactory userFactory,
                                                      IWatchVideoUserGateway watchVideoUserGateway,
                                                      @Qualifier("userCreationMongoDbGateway") IUserExistsGateway userGateway,
                                                      @Qualifier("videoCreationMongoDbGateway") IVideoExistsGateway videoGateway) {
        return new WatchVideoUserInteractor(userPresenter, userFactory, watchVideoUserGateway, userGateway, videoGateway);
    }

}
