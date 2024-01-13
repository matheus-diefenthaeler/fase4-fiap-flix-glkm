package br.com.fiap.fase4streamingvideos.adapter.gateways.mapper;

import br.com.fiap.fase4streamingvideos.application.video.model.response.VideoResponseModel;

public class VideoMapper {

    public static VideoResponseModel toRespondeModel(VideoJpaMapper jpaMapper) {
        VideoResponseModel videoResponseModel = new VideoResponseModel();

        videoResponseModel.setId(jpaMapper.getId());
        videoResponseModel.setTitulo(jpaMapper.getTitle());
        videoResponseModel.setUrl(jpaMapper.getUrl());
        videoResponseModel.setDescricao(jpaMapper.getDescription());
        videoResponseModel.setCreatedAt(String.valueOf(jpaMapper.getCreatedAt()));
        videoResponseModel.setCategory(jpaMapper.getCategory());

        return videoResponseModel;

    }
}