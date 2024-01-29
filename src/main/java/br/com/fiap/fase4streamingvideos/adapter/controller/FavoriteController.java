package br.com.fiap.fase4streamingvideos.adapter.controller;

import br.com.fiap.fase4streamingvideos.application.favorite.boundaries.input.ICreateFavoriteBoundary;
import br.com.fiap.fase4streamingvideos.application.favorite.boundaries.input.IGetAllFavoriteBoundary;
import br.com.fiap.fase4streamingvideos.application.favorite.model.request.FavoriteRequestModel;
import br.com.fiap.fase4streamingvideos.application.favorite.model.response.FavoriteResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/favorite")
@RequiredArgsConstructor
public class FavoriteController {
    private final IGetAllFavoriteBoundary getAllFavoriteBoundary;
    private final ICreateFavoriteBoundary createFavoriteBoundary;

    @GetMapping("/{id}")
    public Flux<FavoriteResponseModel> findAll(@PathVariable String id){
        return getAllFavoriteBoundary.findAllByIdUser(id);
    }

    @PostMapping
    public Mono<ResponseEntity<FavoriteResponseModel>> create(@RequestBody FavoriteRequestModel favoriteRequestModel){
        return createFavoriteBoundary.create(favoriteRequestModel)
                .map(favorite -> ResponseEntity.status(HttpStatus.CREATED).body(favorite));
    }
}
