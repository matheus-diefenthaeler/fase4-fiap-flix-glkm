package br.com.fiap.fase4streamingvideos.adapter.beanconfigs;

import br.com.fiap.fase4streamingvideos.adapter.gateways.h2.VideoCreationH2Gateway;
import br.com.fiap.fase4streamingvideos.adapter.presenter.VideoPresenter;
import br.com.fiap.fase4streamingvideos.application.video.boundaries.input.register.ICreateVideoBoundary;
import br.com.fiap.fase4streamingvideos.application.video.boundaries.input.register.IGetAllVideosBoundary;
import br.com.fiap.fase4streamingvideos.application.video.boundaries.input.register.IReadVideoBoundary;
import br.com.fiap.fase4streamingvideos.application.video.boundaries.output.register.IGetAllVideosGateway;
import br.com.fiap.fase4streamingvideos.application.video.boundaries.output.register.IGetVideoGateway;
import br.com.fiap.fase4streamingvideos.application.video.boundaries.output.register.IVideoRegisterGateway;
import br.com.fiap.fase4streamingvideos.application.video.interactors.CreateVideoInteractor;
import br.com.fiap.fase4streamingvideos.application.video.interactors.GetAllVideosInteractor;
import br.com.fiap.fase4streamingvideos.application.video.interactors.ReadVideoInteractor;
import br.com.fiap.fase4streamingvideos.application.video.presenter.IVideoPresenter;
import br.com.fiap.fase4streamingvideos.domain.factories.IVideoFactory;
import br.com.fiap.fase4streamingvideos.domain.factories.VideoFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VideoConfiguration {

    @Bean
    public IVideoFactory videoFactory(){
        return new VideoFactory();
    }

    @Bean
    public IVideoPresenter videoPresenter(){
        return new VideoPresenter();
    }

    @Bean
    public IVideoRegisterGateway videoRegisterGateway(){
        return new VideoCreationH2Gateway();
    }

    @Bean
    public ICreateVideoBoundary videoInputBoudary(IVideoPresenter videoPresenter, IVideoFactory videoFactory, IVideoRegisterGateway videoRegisterGateway) {
        return new CreateVideoInteractor(videoPresenter, videoFactory, videoRegisterGateway);
    }

    @Bean
    public IReadVideoBoundary readVideoBoundary(IVideoPresenter videoPresenter, IVideoFactory videoFactory, IGetVideoGateway getVideoGateway){
        return new ReadVideoInteractor(videoPresenter, videoFactory, getVideoGateway);
    }

    @Bean
    public IGetAllVideosBoundary getAllVideoBoundary(IVideoPresenter videoPresenter, IVideoFactory videoFactory, IGetAllVideosGateway getAllVideosGateway){
        return new GetAllVideosInteractor(videoPresenter, videoFactory, getAllVideosGateway);
    }
}
