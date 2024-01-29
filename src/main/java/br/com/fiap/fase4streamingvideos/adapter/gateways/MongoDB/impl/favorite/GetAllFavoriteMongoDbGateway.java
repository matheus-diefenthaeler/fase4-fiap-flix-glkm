package br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.impl.favorite;

import br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.mapper.FavoriteMapper;
import br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.model.FavoriteMongoDB;
import br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.repository.IFavoriteMongoDbRepository;
import br.com.fiap.fase4streamingvideos.application.favorite.boundaries.output.IGetAllFavoriteGateway;
import br.com.fiap.fase4streamingvideos.application.favorite.model.response.FavoriteResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class GetAllFavoriteMongoDbGateway implements IGetAllFavoriteGateway {
    @Autowired
    IFavoriteMongoDbRepository _repository;

    public GetAllFavoriteMongoDbGateway() {}

    @Override
    public Flux<FavoriteResponseModel> findAllByIdUser(String id) {
        Flux<FavoriteMongoDB> favorites = _repository.findAllByIdUser(id);

        return FavoriteMapper.listMongoToListResponseModel(favorites);
    }
}
