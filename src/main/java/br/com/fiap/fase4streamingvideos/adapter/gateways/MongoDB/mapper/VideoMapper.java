package br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.mapper;

import br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.model.VideoMongoDB;
import br.com.fiap.fase4streamingvideos.adapter.gateways.mapper.VideoJpaMapper;
import br.com.fiap.fase4streamingvideos.application.video.model.response.VideoResponseModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class VideoMapper {

    public static Mono<VideoResponseModel> toRespondeModel(Mono<VideoMongoDB> videoMono) {
        return videoMono.map(videoMongoDB -> {
            VideoResponseModel videoResponseModel = new VideoResponseModel();

            videoResponseModel.setId(videoMongoDB.getId());
            videoResponseModel.setTitulo(videoMongoDB.getTitle());
            videoResponseModel.setUrl(videoMongoDB.getUrl());
            videoResponseModel.setDescricao(videoMongoDB.getDescription());
            videoResponseModel.setCreatedAt(String.valueOf(videoMongoDB.getCreatedAt()));
            videoResponseModel.setCategory(videoMongoDB.getCategory());

            return videoResponseModel;
        });
    }

    public static Flux<Page<VideoResponseModel>> listMongoToListResponseModel(Flux<VideoMongoDB> videoFlux) {
        return videoFlux.collectList().flatMapMany(videoList -> {
            List<Mono<VideoResponseModel>> responseMonos = videoList.stream()
                    .map(video -> VideoMapper.toRespondeModel(Mono.just(video)))
                    .collect(Collectors.toList());

            return Flux.zip(responseMonos, objects -> Arrays.stream(objects)
                            .map(videoResponseModelMono -> ((Mono<VideoResponseModel>) videoResponseModelMono).block())
                            .collect(Collectors.toList()))
                    .map(responseModelsList ->
                            new PageImpl<>(responseModelsList, Pageable.unpaged(), videoList.size()));
        });
    }
}
