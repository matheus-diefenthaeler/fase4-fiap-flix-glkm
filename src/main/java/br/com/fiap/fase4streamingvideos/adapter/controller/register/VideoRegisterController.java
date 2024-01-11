package br.com.fiap.fase4streamingvideos.adapter.controller.register;

import br.com.fiap.fase4streamingvideos.application.video.boundaries.input.register.IVideoRegisterBoundary;
import br.com.fiap.fase4streamingvideos.application.video.model.request.VideoRequestModel;
import br.com.fiap.fase4streamingvideos.application.video.model.response.VideoResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/videos")
public class VideoRegisterController {


    IVideoRegisterBoundary inputBoundary;

    public VideoRegisterController(IVideoRegisterBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    @PostMapping
    public ResponseEntity<VideoResponseModel> create(@RequestBody VideoRequestModel requestModel) {
        VideoResponseModel responseModel = inputBoundary.create(requestModel);

        return ResponseEntity.ok().body(responseModel);
    }

}
