package br.com.fiap.fase4streamingvideos.adapter.controller;

import br.com.fiap.fase4streamingvideos.application.video.boundaries.input.register.ICreateVideoBoundary;
import br.com.fiap.fase4streamingvideos.application.video.boundaries.output.register.IGetVideoGateway;
import br.com.fiap.fase4streamingvideos.application.video.model.request.VideoRequestModel;
import br.com.fiap.fase4streamingvideos.application.video.model.response.VideoResponseModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/videos")
public class VideoController {

    ICreateVideoBoundary inputBoundary;
    IGetVideoGateway getInputBoundary;

    public VideoController(ICreateVideoBoundary inputBoundary, IGetVideoGateway getInputBoundary) {
        this.inputBoundary = inputBoundary;
        this.getInputBoundary = getInputBoundary;
    }

    @PostMapping
    public ResponseEntity<VideoResponseModel> create(@RequestBody VideoRequestModel requestModel) {
        VideoResponseModel responseModel = inputBoundary.create(requestModel);

        return ResponseEntity.ok().body(responseModel);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VideoResponseModel> findByID(@PathVariable Long id) {
        VideoResponseModel video = getInputBoundary.findById(id);
        return ResponseEntity.ok(video);
    }

}
