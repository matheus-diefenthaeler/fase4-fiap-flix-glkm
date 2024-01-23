package br.com.fiap.fase4streamingvideos.adapter.controller;

import br.com.fiap.fase4streamingvideos.application.user.boundaries.input.ICreateUserBoundary;
import br.com.fiap.fase4streamingvideos.application.user.boundaries.input.IDeleteUserBoundary;
import br.com.fiap.fase4streamingvideos.application.user.boundaries.input.IFindAllUserBoundary;
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

    public UserController(ICreateUserBoundary inputBoundary, IDeleteUserBoundary inputDeleteBoundary, IFindAllUserBoundary inputFindAllBoundary) {
        this.inputBoundary = inputBoundary;
        this.inputDeleteBoundary = inputDeleteBoundary;
        this.inputFindAllBoundary = inputFindAllBoundary;
    }

    @PostMapping
    public Mono<UserResponseModel> create(@RequestBody UserRequestModel requestModel) {
        return inputBoundary.create(requestModel);
    }

    @DeleteMapping("/{email}")
    public Mono<Void> deleteById(@PathVariable String email) {
        return this.inputDeleteBoundary.deleteByEmail(email);
    }

    @GetMapping
    public Flux<UserResponseModel> findAll() {
        return inputFindAllBoundary.findAll();
    }

}
