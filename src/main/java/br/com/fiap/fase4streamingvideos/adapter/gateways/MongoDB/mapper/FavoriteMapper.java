package br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.mapper;

import br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.model.FavoriteMongoDB;
import br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.model.VideoMongoDB;
import br.com.fiap.fase4streamingvideos.application.favorite.model.response.FavoriteResponseModel;
import br.com.fiap.fase4streamingvideos.application.user.model.response.UserResponseModel;
import br.com.fiap.fase4streamingvideos.application.video.model.response.VideoResponseModel;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class FavoriteMapper {

    public static Mono<FavoriteResponseModel> toRespondeModel(Mono<FavoriteMongoDB> favoriteMono) {
        return favoriteMono.map(favoriteMongoDB -> {
            FavoriteResponseModel favoriteResponseModel = new FavoriteResponseModel();

            favoriteResponseModel.setId(favoriteMongoDB.getId());
            favoriteResponseModel.setIdUser(favoriteMongoDB.getIdUser());
            favoriteResponseModel.setIdVideo(favoriteMongoDB.getIdVideo());
            favoriteResponseModel.setNameVideo(favoriteMongoDB.getNameVideo());
            favoriteResponseModel.setAddedAt(String.valueOf(favoriteMongoDB.getAddedAt()));

            return favoriteResponseModel;
        });
    }

    public static Flux<FavoriteResponseModel> listMongoToListResponseModel(Flux<FavoriteMongoDB> favoriteFlux) {
        return favoriteFlux.flatMap(favoriteMongoDB -> toRespondeModel(Mono.just(favoriteMongoDB)));
    }
}
