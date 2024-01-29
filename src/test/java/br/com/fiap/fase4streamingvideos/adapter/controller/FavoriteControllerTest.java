package br.com.fiap.fase4streamingvideos.adapter.controller;

import br.com.fiap.fase4streamingvideos.application.favorite.boundaries.input.ICreateFavoriteBoundary;
import br.com.fiap.fase4streamingvideos.application.favorite.boundaries.input.IGetAllFavoriteBoundary;
import br.com.fiap.fase4streamingvideos.application.favorite.model.request.FavoriteRequestModel;
import br.com.fiap.fase4streamingvideos.application.favorite.model.response.FavoriteResponseModel;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureWebTestClient
class FavoriteControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private IGetAllFavoriteBoundary getAllFavoriteBoundary;

    @MockBean
    private ICreateFavoriteBoundary createFavoriteBoundary;

    @Test
    void testFindAll() {
        when(getAllFavoriteBoundary.findAllByIdUser("user123"))
                .thenReturn(Flux.just(new FavoriteResponseModel("1", "user123", "videoId", "Video 1", "2024-01-28")));

        webTestClient.get()
                .uri("/v1/favorite/user123")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(FavoriteResponseModel.class)
                .hasSize(1)
                .contains(new FavoriteResponseModel("1", "user123", "videoId", "Video 1", "2024-01-28"));
    }

    @Test
    void testCreate() {
        // Mockando o comportamento do createFavoriteBoundary
        when(createFavoriteBoundary.create(any  (FavoriteRequestModel.class)))
                .thenReturn(Mono.just(new FavoriteResponseModel("1", "userId", "videoId", "Video 1", "2024-01-28")));


        // Enviando uma solicitação POST para o endpoint /v1/favorite
        webTestClient.post()
                .uri("/v1/favorite")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(new FavoriteRequestModel("userId", "videoId"))
                .exchange()
                .expectStatus().isCreated()
                .expectBody(FavoriteResponseModel.class)
                .isEqualTo(new FavoriteResponseModel("1", "userId", "videoId", "Video 1", "2024-01-28"));
    }
}
