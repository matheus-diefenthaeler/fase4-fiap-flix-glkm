package br.com.fiap.fase4streamingvideos.adapter.controller;

import br.com.fiap.fase4streamingvideos.application.user.boundaries.input.*;
import br.com.fiap.fase4streamingvideos.application.user.model.request.UserRequestModel;
import br.com.fiap.fase4streamingvideos.application.user.model.response.UserResponseModel;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("v1/users")
public class UserController {

    ICreateUserBoundary inputBoundary;
    IDeleteUserBoundary inputDeleteBoundary;
    IFindAllUserBoundary inputFindAllBoundary;
    IFindByIdUserBoundary inputFindByIdBoundary;
    IGetUserFavoritesBoundary iGetUserFavoritesBoundary;

    public UserController(ICreateUserBoundary inputBoundary, IDeleteUserBoundary inputDeleteBoundary,
                          IFindAllUserBoundary inputFindAllBoundary, IFindByIdUserBoundary inputFindByIdBoundary,
                          IGetUserFavoritesBoundary iGetUserFavoritesBoundary) {
        this.inputBoundary = inputBoundary;
        this.inputDeleteBoundary = inputDeleteBoundary;
        this.inputFindAllBoundary = inputFindAllBoundary;
        this.inputFindByIdBoundary = inputFindByIdBoundary;
        this.iGetUserFavoritesBoundary = iGetUserFavoritesBoundary;
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

    @GetMapping("/{id}/favoritos")
    public Flux<?> getFavorites(@PathVariable String id) {
        return iGetUserFavoritesBoundary.getFavorites(id);

    }

}
