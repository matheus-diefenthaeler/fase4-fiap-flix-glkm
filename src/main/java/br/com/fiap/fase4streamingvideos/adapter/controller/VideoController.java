package br.com.fiap.fase4streamingvideos.adapter.controller;

import br.com.fiap.fase4streamingvideos.application.video.boundaries.input.register.*;
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
    IUpdateVideoBoundary updateVideoBoundary;
    IDeleteVideoBoundary deleteVideoBoundary;

    public VideoController(ICreateVideoBoundary inputBoundary, IReadVideoBoundary readVideoBoundary, IGetAllVideosBoundary getAllVideoBoundary, IUpdateVideoBoundary updateVideoBoundary, IDeleteVideoBoundary deleteVideoBoundary) {
        this.inputBoundary = inputBoundary;
        this.readVideoBoundary = readVideoBoundary;
        this.getAllVideoBoundary = getAllVideoBoundary;
        this.updateVideoBoundary = updateVideoBoundary;
        this.deleteVideoBoundary = deleteVideoBoundary;
    }

    @GetMapping("/{id}")
    public ResponseEntity<VideoResponseModel> findByID(@PathVariable Long id) {
        VideoResponseModel video = readVideoBoundary.findById(id);
        return ResponseEntity.ok(video);
    }

    @GetMapping
    public ResponseEntity<Page<VideoResponseModel>> findAll(Pageable pageable) {
        Page<VideoResponseModel> videos = getAllVideoBoundary.findAll(pageable);
        return ResponseEntity.ok(videos);
    }

    @PostMapping
    public ResponseEntity<VideoResponseModel> create(@RequestBody VideoRequestModel requestModel) {
        VideoResponseModel responseModel = inputBoundary.create(requestModel);

        return ResponseEntity.ok().body(responseModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VideoResponseModel> update(@PathVariable Long id, @RequestBody VideoRequestModel requestModel) {
        VideoResponseModel responseModel = updateVideoBoundary.updateById(id, requestModel);

        return ResponseEntity.ok().body(responseModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        deleteVideoBoundary.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
