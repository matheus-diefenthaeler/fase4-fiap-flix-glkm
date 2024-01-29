package br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.impl.favorite;

import br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.mapper.FavoriteMapper;
import br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.mapper.VideoMapper;
import br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.model.FavoriteMongoDB;
import br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.model.VideoMongoDB;
import br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.repository.IFavoriteMongoDbRepository;
import br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.repository.IVideoMongoDbRepository;
import br.com.fiap.fase4streamingvideos.application.favorite.boundaries.output.ICreateFavoriteGateway;
import br.com.fiap.fase4streamingvideos.application.favorite.model.response.FavoriteResponseModel;
import br.com.fiap.fase4streamingvideos.application.video.boundaries.output.register.IVideoRegisterGateway;
import br.com.fiap.fase4streamingvideos.application.video.model.response.VideoResponseModel;
import br.com.fiap.fase4streamingvideos.domain.IFavorite;
import br.com.fiap.fase4streamingvideos.domain.IVideo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class CreateFavoriteMongoDbGateway implements ICreateFavoriteGateway {
    @Autowired
    IFavoriteMongoDbRepository _repository;

    public CreateFavoriteMongoDbGateway() {}

    @Override
    public Mono<FavoriteResponseModel> save(IFavorite iFavorite) {
        FavoriteMongoDB favorite = new FavoriteMongoDB(iFavorite.getIdUser(), iFavorite.getIdVideo(), iFavorite.getNameVideo(), iFavorite.getAddedAt());
        Mono<FavoriteMongoDB> saveMono = _repository.save(favorite);

        return FavoriteMapper.toRespondeModel(saveMono);
    }

    @Override
    public Mono<Boolean> existsByIdVideoAndIdUser(String idVideo, String idUser) {
        return _repository.existsByIdVideoAndIdUser(idVideo, idUser);
    }
}
