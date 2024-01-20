package br.com.fiap.fase4streamingvideos.adapter.controller;

import br.com.fiap.fase4streamingvideos.application.user.boundaries.input.ICreateUserBoundary;
import br.com.fiap.fase4streamingvideos.application.user.model.request.UserRequestModel;
import br.com.fiap.fase4streamingvideos.application.user.model.response.UserResponseModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("v1/users")
public class UserController {

    ICreateUserBoundary inputBoundary;

    public UserController(ICreateUserBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    @PostMapping
    public Mono<UserResponseModel> create(@RequestBody UserRequestModel requestModel) {
        return Mono.just(inputBoundary.create(requestModel));
//                .flatMap(responseModel -> Mono.justOrEmpty(responseModel));
    }
}
