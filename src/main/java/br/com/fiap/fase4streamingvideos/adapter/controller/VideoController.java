package br.com.fiap.fase4streamingvideos.adapter.controller;

import br.com.fiap.fase4streamingvideos.application.video.boundaries.input.register.ICreateVideoBoundary;
import br.com.fiap.fase4streamingvideos.application.video.boundaries.input.register.IGetAllVideosBoundary;
import br.com.fiap.fase4streamingvideos.application.video.boundaries.input.register.IReadVideoBoundary;
import br.com.fiap.fase4streamingvideos.application.video.model.request.VideoRequestModel;
import br.com.fiap.fase4streamingvideos.application.video.model.response.VideoResponseModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/videos")
public class VideoController {
    ICreateVideoBoundary inputBoundary;
    IReadVideoBoundary readVideoBoundary;
    IGetAllVideosBoundary getAllVideoBoundary;

    public VideoController(ICreateVideoBoundary inputBoundary, IReadVideoBoundary readVideoBoundary, IGetAllVideosBoundary getAllVideoBoundary) {
        this.inputBoundary = inputBoundary;
        this.readVideoBoundary = readVideoBoundary;
        this.getAllVideoBoundary = getAllVideoBoundary;
    }

    @PostMapping
    public ResponseEntity<VideoResponseModel> create(@RequestBody VideoRequestModel requestModel) {
        VideoResponseModel responseModel = inputBoundary.create(requestModel);

        return ResponseEntity.ok().body(responseModel);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VideoResponseModel> findByID(@PathVariable Long id) {
        VideoResponseModel video = readVideoBoundary.findById(id);
        return ResponseEntity.ok(video);
    }

    @GetMapping
    public ResponseEntity<List<VideoResponseModel>> findAll() {
        List<VideoResponseModel> videos = getAllVideoBoundary.findAll();
        return ResponseEntity.ok(videos);
    }
}
