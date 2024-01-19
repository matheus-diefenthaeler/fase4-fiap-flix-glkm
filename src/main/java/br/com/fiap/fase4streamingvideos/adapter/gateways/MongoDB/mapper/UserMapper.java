package br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.mapper;

import br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.model.UserMongoDB;
import br.com.fiap.fase4streamingvideos.application.user.model.response.UserResponseModel;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {

//    public static Mono<UserResponseModel> toResponseModel(Mono<UserMongoDB> userMono) {
//        return userMono.map(userMongoDB -> {
//            UserResponseModel userResponseModel = new UserResponseModel();
//            List<String> filmesFavoritos = new ArrayList<>();
//
//            userResponseModel.setId(userMongoDB.getId());
//            userResponseModel.setName(userMongoDB.getName());
//            userResponseModel.setEmail(userMongoDB.getEmail());
//
//            userMongoDB.getFavoriteVideos().forEach(favoriteVideo -> {
//                filmesFavoritos.add(favoriteVideo.getTitle());
//            });
//
//            userResponseModel.setFilmesFavoritos(filmesFavoritos);
//
//            return userResponseModel;
//        });
//    }

    public static UserResponseModel toResponseModel(UserMongoDB userMongoDB) {
        if (userMongoDB != null) {
            UserResponseModel userResponseModel = new UserResponseModel();
            List<String> filmesFavoritos = new ArrayList<>();

            userResponseModel.setId(userMongoDB.getId());
            userResponseModel.setName(userMongoDB.getName());
            userResponseModel.setEmail(userMongoDB.getEmail());

            userMongoDB.getFavoriteVideos().forEach(favoriteVideo -> {
                filmesFavoritos.add(favoriteVideo.getTitle());
            });

            userResponseModel.setFilmesFavoritos(filmesFavoritos);

            return userResponseModel;
        } else {
            return null;
        }
    }


}
