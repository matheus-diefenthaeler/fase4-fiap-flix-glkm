package br.com.fiap.fase4streamingvideos.adapter.controller;

import br.com.fiap.fase4streamingvideos.application.user.boundaries.input.ICreateUserBoundary;
import br.com.fiap.fase4streamingvideos.application.user.model.request.UserRequestModel;
import br.com.fiap.fase4streamingvideos.application.user.model.response.UserResponseModel;
import br.com.fiap.fase4streamingvideos.application.video.model.request.VideoRequestModel;
import br.com.fiap.fase4streamingvideos.application.video.model.response.VideoResponseModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/users")
public class UserController {

    ICreateUserBoundary inputBoundary;

    public UserController(ICreateUserBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    @PostMapping
    public ResponseEntity<UserResponseModel> create(@RequestBody UserRequestModel requestModel) {
        UserResponseModel responseModel = inputBoundary.create(requestModel);

        return ResponseEntity.ok().body(responseModel);
    }
}
