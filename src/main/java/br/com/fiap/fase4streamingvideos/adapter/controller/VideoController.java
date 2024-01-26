package br.com.fiap.fase4streamingvideos.adapter.controller;

import br.com.fiap.fase4streamingvideos.application.video.boundaries.input.register.*;
import br.com.fiap.fase4streamingvideos.application.video.model.request.VideoRequestModel;
import br.com.fiap.fase4streamingvideos.application.video.model.response.VideoResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/videos")
@RequiredArgsConstructor
public class VideoController {

    private final ICreateVideoBoundary inputBoundary;
    private final IReadVideoBoundary readVideoBoundary;
    private final IGetAllVideosBoundary getAllVideoBoundary;
    private final IUpdateVideoBoundary updateVideoBoundary;
    private final IDeleteVideoBoundary deleteVideoBoundary;

    @GetMapping("/{id}")
    public Mono<VideoResponseModel> findByID(@PathVariable String id) {
        return readVideoBoundary.findById(id);
    }

    @GetMapping
    public Flux<Page<VideoResponseModel>> findAll(@PageableDefault(size = 10) @RequestParam(name = "page", defaultValue = "0") int page,
                                                  @PageableDefault(size = 10) @RequestParam(name = "size", defaultValue = "10") int size,
                                                  @RequestParam(name = "sort", defaultValue = "createdAt,desc") String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort.split(",")));
        return getAllVideoBoundary.findAll(pageable);
    }

    @PostMapping
    public Mono<VideoResponseModel> create(@RequestBody VideoRequestModel requestModel) {
        return inputBoundary.create(requestModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mono<VideoResponseModel>> update(@PathVariable String id, @RequestBody VideoRequestModel requestModel) {
        Mono<VideoResponseModel> responseModel = updateVideoBoundary.updateById(id, requestModel);

        return ResponseEntity.ok().body(responseModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Mono<Void>> delete(@PathVariable String id) {
        this.deleteVideoBoundary.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
