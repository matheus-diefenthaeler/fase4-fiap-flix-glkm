package br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.impl.user;

import br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.mapper.UserMapper;
import br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.repository.IUserMongoDbRepository;
import br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.repository.IVideoMongoDbRepository;
import br.com.fiap.fase4streamingvideos.application.user.boundaries.output.IUserFindByIdGateway;
import br.com.fiap.fase4streamingvideos.application.user.boundaries.output.IWatchVideoUserGateway;
import br.com.fiap.fase4streamingvideos.application.user.model.response.UserResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class WatchVideoUserMongoDbGateway implements IWatchVideoUserGateway {

    @Autowired
    IVideoMongoDbRepository repository;

    public WatchVideoUserMongoDbGateway() {
    }

//    @Override
//    public Mono<Void> incrementViews(String videoId) {
//        return repository.findById(videoId)
//                .flatMap(video -> {
//                    video.setViews(video.getViews() + 1); // Incrementa as visualizações do vídeo
//                    return repository.save(video);
//                })
//                .then();
//    }

    @Override
    public Mono<Boolean> incrementViews(String videoId) {
        return repository.findById(videoId)
                .flatMap(video -> {
                    if (video != null) {
                        video.setViews(video.getViews() + 1); // Incrementa as visualizações do vídeo
                        return repository.save(video).thenReturn(true);
                    }
                    return Mono.just(false);
                })
                .defaultIfEmpty(false);
    }
}
