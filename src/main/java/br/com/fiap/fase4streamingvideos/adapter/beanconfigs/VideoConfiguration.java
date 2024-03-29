package br.com.fiap.fase4streamingvideos.adapter.beanconfigs;

import br.com.fiap.fase4streamingvideos.adapter.presenter.VideoPresenter;
import br.com.fiap.fase4streamingvideos.application.video.boundaries.input.register.*;
import br.com.fiap.fase4streamingvideos.application.video.boundaries.output.register.*;
import br.com.fiap.fase4streamingvideos.application.video.interactors.*;
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
    public ICreateVideoBoundary videoInputBoudary(IVideoPresenter videoPresenter, IVideoFactory videoFactory, IVideoRegisterGateway videoRegisterGateway) {
        return new CreateVideoInteractor(videoPresenter, videoFactory, videoRegisterGateway);
    }

    @Bean
    public IReadVideoBoundary readVideoBoundary(IVideoPresenter videoPresenter, IVideoFactory videoFactory, IGetVideoGateway getVideoGateway){
        return new ReadVideoInteractor(videoPresenter, videoFactory, getVideoGateway);
    }

    @Bean
    public IGetAllVideosBoundary getAllVideoBoundary(IVideoPresenter videoPresenter, IGetAllVideosGateway getAllVideosGateway){
        return new GetAllVideosInteractor(videoPresenter, getAllVideosGateway);
    }

    @Bean
    public IUpdateVideoBoundary updateVideoBoundary(IVideoPresenter videoPresenter, IUpdateVideoGateway updateVideoGateway, IReadVideoBoundary getVideoBoundary){
        return new UpdateVideoInteractor(videoPresenter, updateVideoGateway, getVideoBoundary);
    }

    @Bean
    public IDeleteVideoBoundary deleteVideoBoundary(IVideoPresenter videoPresenter, IDeleteVideoGateway deleteVideoGateway, IReadVideoBoundary getVideoBoundary){
        return new DeleteVideoInteractor(videoPresenter, deleteVideoGateway, getVideoBoundary);
    }
}
