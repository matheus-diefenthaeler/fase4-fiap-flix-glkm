package br.com.fiap.fase4streamingvideos.adapter.controller;

import br.com.fiap.fase4streamingvideos.adapter.gateways.MongoDB.dto.request.WatchVideoRequest;
import br.com.fiap.fase4streamingvideos.application.user.boundaries.input.*;
import br.com.fiap.fase4streamingvideos.application.user.model.request.UserRequestModel;
import br.com.fiap.fase4streamingvideos.application.user.model.response.UserResponseModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    ICreateUserBoundary inputBoundary;
    IDeleteUserBoundary inputDeleteBoundary;
    IFindAllUserBoundary inputFindAllBoundary;
    IFindByIdUserBoundary inputFindByIdBoundary;
    IGetUserFavoritesBoundary iGetUserFavoritesBoundary;
    IUserWatchVideoBoundary iUserWatchVideoBoundary;

    public UserController(ICreateUserBoundary inputBoundary, IDeleteUserBoundary inputDeleteBoundary, IFindAllUserBoundary inputFindAllBoundary, IFindByIdUserBoundary inputFindByIdBoundary, IGetUserFavoritesBoundary iGetUserFavoritesBoundary, @Qualifier("watchVideoBoundary") IUserWatchVideoBoundary iUserWatchVideoBoundary) {
        this.inputBoundary = inputBoundary;
        this.inputDeleteBoundary = inputDeleteBoundary;
        this.inputFindAllBoundary = inputFindAllBoundary;
        this.inputFindByIdBoundary = inputFindByIdBoundary;
        this.iGetUserFavoritesBoundary = iGetUserFavoritesBoundary;
        this.iUserWatchVideoBoundary = iUserWatchVideoBoundary;
    }

    @PostMapping
    public Mono<UserResponseModel> create(@RequestBody UserRequestModel requestModel) {
        return inputBoundary.create(requestModel);
    }

    @DeleteMapping("/{email}")
    public Mono<Void> deleteByEmail(@PathVariable String email) {
        return this.inputDeleteBoundary.deleteByEmail(email);
    }

    @GetMapping
    public Flux<UserResponseModel> findAll() {
        return inputFindAllBoundary.findAll();
    }

    @GetMapping("/{id}")
    public Mono<UserResponseModel> findById(@PathVariable String id) {
        return inputFindByIdBoundary.findById(id);
    }

    @GetMapping("/{id}/favorites")
    public Flux<?> getFavorites(@PathVariable String id) {
        return iGetUserFavoritesBoundary.getFavorites(id);
    }

    @PostMapping("/watch/{videoId}/")
    public Mono<ResponseEntity<Void>> watch(@RequestBody WatchVideoRequest request, @PathVariable String videoId) {
        return iUserWatchVideoBoundary.toWatch(request, videoId).then(Mono.just(ResponseEntity.noContent().<Void>build()));
    }
}
