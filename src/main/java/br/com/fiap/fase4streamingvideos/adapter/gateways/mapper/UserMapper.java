package br.com.fiap.fase4streamingvideos.adapter.gateways.mapper;

import br.com.fiap.fase4streamingvideos.application.user.model.response.UserResponseModel;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    public static UserResponseModel toRespondeModel(UserJpaMapper jpaMapper) {
        UserResponseModel userResponseModel = new UserResponseModel();
        List<String> filmesFavoritos = new ArrayList<>();

        userResponseModel.setId(jpaMapper.getId());
        userResponseModel.setName(jpaMapper.getName());
        userResponseModel.setEmail(jpaMapper.getEmail());

        jpaMapper.getFavoriteVideos().forEach((favoriteVideo) -> {
            filmesFavoritos.add(favoriteVideo.getVideoTitle());
        });

        userResponseModel.setFilmesFavoritos(filmesFavoritos);

        return userResponseModel;

    }
}
