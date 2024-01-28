package br.com.fiap.fase4streamingvideos.adapter.beanconfigs;

import br.com.fiap.fase4streamingvideos.adapter.presenter.FavoritePresenter;
import br.com.fiap.fase4streamingvideos.application.favorite.boundaries.input.ICreateFavoriteBoundary;
import br.com.fiap.fase4streamingvideos.application.favorite.boundaries.input.IGetAllFavoriteBoundary;
import br.com.fiap.fase4streamingvideos.application.favorite.boundaries.output.ICreateFavoriteGateway;
import br.com.fiap.fase4streamingvideos.application.favorite.boundaries.output.IGetAllFavoriteGateway;
import br.com.fiap.fase4streamingvideos.application.favorite.interactors.CreateFavoriteInteractor;
import br.com.fiap.fase4streamingvideos.application.favorite.interactors.GetAllFavoriteInteractor;
import br.com.fiap.fase4streamingvideos.application.favorite.presenter.IFavoritePresenter;
import br.com.fiap.fase4streamingvideos.application.user.boundaries.input.IFindByIdUserBoundary;
import br.com.fiap.fase4streamingvideos.application.video.boundaries.input.register.IReadVideoBoundary;
import br.com.fiap.fase4streamingvideos.domain.factories.FavoriteFactory;
import br.com.fiap.fase4streamingvideos.domain.factories.IFavoriteFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FavoriteConfiguration {
    @Bean
    public IFavoriteFactory favoriteFactory() {
        return new FavoriteFactory();
    }

    @Bean
    public IFavoritePresenter favoritePresenter() {
        return new FavoritePresenter();
    }

    @Bean
    public ICreateFavoriteBoundary favoriteInputBoundary(IFavoritePresenter favoritePresenter, IFavoriteFactory favoriteFactory, ICreateFavoriteGateway favoriteGateway, IReadVideoBoundary readVideoBoundary, IFindByIdUserBoundary findByIdUserBoundary) {
        return new CreateFavoriteInteractor(favoritePresenter, favoriteFactory, favoriteGateway, readVideoBoundary, findByIdUserBoundary);
    }

    @Bean
    public IGetAllFavoriteBoundary getAllFavoriteBoundary(IFavoritePresenter favoritePresenter, IFavoriteFactory favoriteFactory, IGetAllFavoriteGateway favoriteGateway) {
        return new GetAllFavoriteInteractor(favoritePresenter, favoriteGateway);
    }
}
