package br.com.fiap.fase4streamingvideos.adapter.controller;

import br.com.fiap.fase4streamingvideos.application.video.boundaries.input.register.*;
import br.com.fiap.fase4streamingvideos.application.video.model.request.VideoRequestModel;
import br.com.fiap.fase4streamingvideos.application.video.model.response.VideoResponseModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
    public Mono<ResponseEntity<VideoResponseModel>> findByID(@PathVariable String id) {
        return readVideoBoundary.findById(id)
                .map(video -> ResponseEntity.ok().body(video));
    }

    @GetMapping
    public Flux<Page<VideoResponseModel>> findAll(@PageableDefault(size = 10) @RequestParam(name = "page", defaultValue = "0") int page,
                                                  @PageableDefault(size = 10) @RequestParam(name = "size", defaultValue = "10") int size,
                                                  @RequestParam(name = "sort", defaultValue = "createdAt,desc") String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort.split(",")));
        return getAllVideoBoundary.findAll(pageable);
    }

    @PostMapping
    public Mono<ResponseEntity<VideoResponseModel>> create(@RequestBody VideoRequestModel requestModel) {
        return inputBoundary.create(requestModel)
                .map(createdVideo -> ResponseEntity.status(HttpStatus.CREATED).body(createdVideo));
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<VideoResponseModel>> update(@PathVariable String id, @RequestBody VideoRequestModel requestModel) {
        return updateVideoBoundary.updateById(id, requestModel)
                .map(updatedVideo -> ResponseEntity.ok().body(updatedVideo));
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable String id) {
        return deleteVideoBoundary.deleteById(id)
                .then(Mono.just(ResponseEntity.noContent().<Void>build()));
    }
}
